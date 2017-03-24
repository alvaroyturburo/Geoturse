package es.codigoandroid.geoturse;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Document;
import com.couchbase.lite.UnsavedRevision;
import com.couchbase.lite.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import es.codigoandroid.es.codigoandroid.datamanager.CouchbaseManager;
import es.codigoandroid.pojos.Recurso;
import es.codigoandroid.pojos.Recursos;
import es.codigoandroid.pojos.Senderos;

public class Splash extends AppCompatActivity {
    private static final String TAG = "Splash";
    CouchbaseManager<String, Recursos> dbaRecurso;


    private Bitmap mImageToBeAttached;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        dbaRecurso = new CouchbaseManager<String, Recursos>(this, Recursos.class);
        Recursos recursoIngresado = new Recursos();
        Senderos senderoIngresado = new Senderos();
        recursoIngresado.setNombre("Playa de San Pablo");
        recursoIngresado.setDescripcion("La playa de San Pablo es definitivamente el refugio idóneo para quienes desean relajar cuerpo y espíritu.");
        recursoIngresado.setInformacionGeneral("El contacto con el mar, la arena y el hermoso paisaje de la playa San Pablo, invitan a los turistas a reconciliarse con la naturaleza.");
        recursoIngresado.setDireccion("Ubicado en el Zona Norte del canton Santa Elena");
        recursoIngresado.setPosicion("-2.140312, -80.776398");

       /* ArrayList<String> puntosSedero = new ArrayList<String>();
        puntosSedero.add("-1.974413, -80.748873");
        puntosSedero.add("-1.974178, -80.748963");
        puntosSedero.add("-1.974097, -80.748974");
        puntosSedero.add("-1.974102, -80.748942");
        puntosSedero.add("-1.974071, -80.748946");
        puntosSedero.add("-1.974023, -80.748946");
        puntosSedero.add("-1.973953, -80.748951");
        puntosSedero.add("-1.973885, -80.748955");
        puntosSedero.add("-1.973822, -80.748960");
        senderoIngresado.setRecorrido(puntosSedero);

        ArrayList<Senderos> listaSederos = new ArrayList<Senderos>();
        listaSederos.add(senderoIngresado);
        recursoIngresado.setSendero(listaSederos);*/

        dbaRecurso.save(recursoIngresado);

        Document docretorno = dbaRecurso.devolverDocument(recursoIngresado.getNombre());

        //La imagen la guardo como attached no como objeto Imagen
        mImageToBeAttached = BitmapFactory.decodeResource(getResources(), R.drawable.sanpablo);
        attachImage(docretorno, mImageToBeAttached);
        Log.v("PruebaRegistro", "Recurso Registrado");


        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(Splash.this,Inicio_Sesion.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

    private void attachImage(Document task, Bitmap image) {
        if (task == null || image == null) return;

        UnsavedRevision revision = task.createRevision();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 50, out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        revision.setAttachment("image", "image/jpg", in);

        try {
            revision.save();
            Log.v("PruebaRegistro", "Recurso Registrado con imagen");
        } catch (CouchbaseLiteException e) {
            Log.e(this.TAG, "Cannot attach image", e);
        }
    }
}
