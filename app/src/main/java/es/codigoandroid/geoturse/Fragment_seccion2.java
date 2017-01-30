package es.codigoandroid.geoturse;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Emitter;
import com.couchbase.lite.Mapper;
import com.couchbase.lite.Query;
import com.couchbase.lite.QueryEnumerator;
import com.couchbase.lite.QueryRow;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import es.codigoandroid.es.codigoandroid.datamanager.CouchbaseManager;
import es.codigoandroid.pojos.Recurso;


public class Fragment_seccion2 extends Fragment {
    private static final String TAG = "Fragment_seccion2";
    CouchbaseManager<String, Recurso> dbaRecurso;


    private ArrayList<Recurso> recursos;
    private RecyclerView rvListaRecurso;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_seccion2, container, false);

        dbaRecurso = new CouchbaseManager<String, Recurso>(this.getActivity(), Recurso.class);

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
        recursos = new ArrayList<>();
        final Query queryPlaces = dbaRecurso.registerViews().createQuery();
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
            //Map<String, Object> properties = database.getDocument(row.getDocumentId()).getProperties();
            Recurso recursoAlmacenado = dbaRecurso.get(row.getKey().toString());
            recursoAlmacenado.setImagen(R.drawable.parapente_ver);
            recursos.add(recursoAlmacenado);
            //recursos.add(new Recurso((JsonObject) row.getValue()));
        }

        //adapter.dataSet = places;

        recursos.add(new Recurso(R.drawable.parapente_ver,"Parapente",3));
        recursos.add(new Recurso(R.drawable.salinas_ver,"Salinas",5));
        recursos.add(new Recurso(R.drawable.chocolatera_ver,"Chocolatera",8));
        recursos.add(new Recurso(R.drawable.escolleras_ver,"Escolleras",10));

    }

    public ListaRecursoAdapter adaptador;
    private void inicializarAdaptador(){
        adaptador = new ListaRecursoAdapter(recursos);
        rvListaRecurso.setAdapter(adaptador);
    }


}
