package es.codigoandroid.geoturse;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    //private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senderos);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

       /* UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setScrollGesturesEnabled(true);
        uiSettings.setTiltGesturesEnabled(true);
        uiSettings.setZoomControlsEnabled(true);*/


        LatLng upse = new LatLng(-2.231315, -80.879934);
       /* mMap.addMarker(new MarkerOptions().position(upse).title("punto UPSE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(upse));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        */
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(upse)
                .zoom(17)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        PolylineOptions sendero = new PolylineOptions()
                .add(new LatLng(-2.231315, -80.879934))
                .add(new LatLng(-2.231572, -80.879880))
                .add(new LatLng(-2.231808, -80.879826))
                .add(new LatLng(-2.232087, -80.879762))
                .add(new LatLng(-2.232312, -80.879719))
                .add(new LatLng(-2.232666, -80.879644))
                .add(new LatLng(-2.232869, -80.879590))
                .add(new LatLng(-2.233041, -80.879547))
                .add(new LatLng(-2.233223, -80.879494))
                .add(new LatLng(-2.233427, -80.879472))
                .add(new LatLng(-2.233652, -80.879419))
                .add(new LatLng(-2.233856, -80.879365))
                .add(new LatLng(-2.234092, -80.879279))
                .add(new LatLng(-2.234156, -80.879279))
                .add(new LatLng(-2.234210, -80.879247))
                .add(new LatLng(-2.234306, -80.879343))
                .add(new LatLng(-2.234478, -80.879461))
                .add(new LatLng(-2.234649, -80.879579))
                .add(new LatLng(-2.234810, -80.879676))
                .add(new LatLng(-2.234993, -80.879751))
                .add(new LatLng(-2.235132, -80.879783))
                .add(new LatLng(-2.235293, -80.879805))
                .add(new LatLng(-2.235486, -80.879740))
                .width(5)
                .color(Color.BLUE)
                .geodesic(true);

        Polyline polyline = mMap.addPolyline(sendero);


    }



}
