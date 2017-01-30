package es.codigoandroid.es.codigoandroid.datamanager;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Emitter;
import com.couchbase.lite.Manager;
import com.couchbase.lite.Mapper;
import com.couchbase.lite.View;
import com.couchbase.lite.android.AndroidContext;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import es.codigoandroid.geoturse.Fragment_seccion3;
import es.codigoandroid.pojos.Recursos;
import es.codigoandroid.pojos.Usuario;

//import com.couchbase.client.CouchbaseClient;

/**
 * Created by ivans on 14-Nov-16.
 * Taken from StackOverflow... the place that holds the answers of life, the universe and everything
 * User: user1697575
 * http://stackoverflow.com/questions/25898023/couchbase-lite-on-android-general-architecture
 */

public class CouchbaseManager<K, V>
{
    private final Class<V> valueTypeParameterClass;
    final ObjectMapper mapper = new ObjectMapper();
    //Debe ser cambiado por un cliente para android
    //@Inject
    //private CouchbaseClient cbClient;

    private final String dataBaseName = "geoturse";
    Manager couchBaseLiteManager;
    Database dbCouchbase;
    Activity act; //La actividad que llama a la clase
   // Fragment frag;//Prueba para fragmentos

    //@Inject
    //private Gson gson;

    public CouchbaseManager(Activity act, final Class<V> valueClass)
    {
        this.act = act;
        AndroidContext context = new AndroidContext(act.getApplicationContext());
        this.valueTypeParameterClass = valueClass;
        configurarMapper();

        try {

            couchBaseLiteManager = new Manager(context, Manager.DEFAULT_OPTIONS);
            dbCouchbase = couchBaseLiteManager.getDatabase(dataBaseName);

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("ErrorCouchbase", "Error en iniciar couchbase manager: " +
                    e.getMessage(), e);
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
            Log.e("ErrorCouchbase", "Error de libreria Couchbase lite: " +
                    e.getMessage(), e);
        }
    }

  /*  public CouchbaseManager(Fragment fragment, Class<V> usuarioClass) {
    }*/

    private void configurarMapper()
    {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * Obtiene cualquier documento de la base (si existe) y lo deserializa a su clase
     * adecuada a traves de Genericos.
     * @param key
     * @return
     */
    public V get(K key)
    {
        //Convertir la Llave a String...
        // Por alguna razon el codigo original asume que puede haber otro tipo de llaves
        // pero los metodos oficiales de CouchBase no soportan eso
        String llave = key.toString();

        V res = null;
        if (key != null)
        {
            Document doc = dbCouchbase.getExistingDocument(llave);

            if (doc != null)
            {
                try {
                    Map<String, Object> map = doc.getProperties();
                    res = mapper.convertValue(map, valueTypeParameterClass);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    Log.e("ErrorCouchbase", "Error de conversion de Map: " +
                            e.getMessage(), e);
                }
            }
        }
        return res;
    }

    /**
     * Persiste cualquier objeto serializable e
     * @param o
     */
    public void save(Object o)
    {

        Map<String, Object> props = mapper.convertValue(o, Map.class);
        String id = (String) props.get("_id");

        //Ponerle el tipo de Documento que estamos guardando para poder buscarlo con vistas luego
        props.put("documentClass", valueTypeParameterClass.toString());

        Document document;
        if(id == null)
        {
            document = getDbCouchbase().createDocument();
        }else{
            document = getDbCouchbase().getExistingDocument(id);

            if(document==null)
            {
                document = getDbCouchbase().getDocument(id);
            }else{
                props.put("_rev",document.getProperty("_rev"));
            }

        }

        try{
            document.putProperties(props);
        }catch (CouchbaseLiteException e)
        {
            e.printStackTrace();
            Log.i("CouchDB-Save", "Failed to write document to Couchbase database!: "+ e.getMessage());
        }
    }

    public Manager getCouchBaseLiteManager() {
        return couchBaseLiteManager;
    }

    public Database getDbCouchbase() {
        return dbCouchbase;
    }

    public View registerViews() {
        View placesView = dbCouchbase.getView("lista_recursos");
        placesView.setMap(new Mapper() {
            @Override
            public void map(Map<String, Object> document, Emitter emitter) {

                if (valueTypeParameterClass.toString().equals(document.get("documentClass"))) {
                    emitter.emit(document.get("_id"), document);
                }
            }
        }, "1");
        return placesView;
    }


}
