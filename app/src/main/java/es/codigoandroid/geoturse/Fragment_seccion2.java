package es.codigoandroid.geoturse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Query;
import com.couchbase.lite.QueryEnumerator;
import com.couchbase.lite.QueryRow;

import java.util.ArrayList;
import java.util.Iterator;

import es.codigoandroid.es.codigoandroid.datamanager.CouchbaseManager;
import es.codigoandroid.pojos.Recursos;


public class Fragment_seccion2 extends Fragment {
    private static final String TAG = "Fragment_seccion2";
    CouchbaseManager<String, Recursos> dbaRecurso_f2;
    private ArrayList<Recursos> recursos_f2;
    private RecyclerView rvListaRecurso;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_seccion2, container, false);

        dbaRecurso_f2 = new CouchbaseManager<String, Recursos>(this.getActivity(), Recursos.class);

        rvListaRecurso = (RecyclerView) vista.findViewById(R.id.reciclador);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaRecurso.setLayoutManager(llm);

        inicializarDatos();
        inicializarAdaptador();
        //  "Inflamos" el archivo XML correspondiente a esta sección.
        return vista;
    }

    public void inicializarDatos(){
        recursos_f2 = new ArrayList<>();
        final Query queryPlaces = dbaRecurso_f2.registerViews().createQuery();
        QueryEnumerator rows = null;
        try {
            rows = queryPlaces.run();
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }
        for (Iterator<QueryRow> it = rows; it.hasNext(); ) {
            QueryRow row = it.next();

            Log.d("Estoy aki", row.getValue().toString());
            Log.d("Estoy aki clave", row.getKey().toString());
            Recursos recursoAlmacenado = dbaRecurso_f2.get(row.getKey().toString());
            recursos_f2.add(recursoAlmacenado);

        }


    }

    public ListaRecursoAdapter adaptador;
    private void inicializarAdaptador(){
        adaptador = new ListaRecursoAdapter(recursos_f2, dbaRecurso_f2.getDbCouchbase());
        rvListaRecurso.setAdapter(adaptador);
    }


}
