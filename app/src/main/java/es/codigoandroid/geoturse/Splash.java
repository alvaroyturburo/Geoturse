package es.codigoandroid.geoturse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.couchbase.lite.util.Log;

import es.codigoandroid.es.codigoandroid.datamanager.CouchbaseManager;
import es.codigoandroid.pojos.Recurso;

public class Splash extends AppCompatActivity {
    private static final String TAG = "Splash";
    CouchbaseManager<String, Recurso> dbaRecurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dbaRecurso = new CouchbaseManager<String, Recurso>(this, Recurso.class);
        Recurso recursoIngresado = new Recurso();
        recursoIngresado.setNombre("Recurso"+5);
        recursoIngresado.setVisitas(5);
        dbaRecurso.save(recursoIngresado);
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
}
