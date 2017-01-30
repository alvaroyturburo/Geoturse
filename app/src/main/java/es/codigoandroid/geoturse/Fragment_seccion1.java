package es.codigoandroid.geoturse;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Locale;


public class Fragment_seccion1 extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;
    LatLng upse, upse2, upse3,upse4;
    Location loc;
    private LocationManager locManager;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        //  "Inflamos" el archivo XML correspondiente a esta sección.
        final View vista = inflater.inflate(R.layout.fragment_seccion1, container, false);
        inicLocation();
        registerLocation();
        //loc = new Location(String.valueOf(new LatLng(-2.229612,-80.8820533)));



        upse = new LatLng(-2.226289, -80.892688); // 3 km
        upse2 = new LatLng(-2.209825, -80.950250); // 9 km
        upse3 = new LatLng(-2.196617, -80.984926);// 12 km
        upse4 = new LatLng(-2.188683, -81.011017);// 16 km

        mMapView = (MapView) vista.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                googleMap.setMyLocationEnabled(true);

               /* googleMap.addMarker(new MarkerOptions().position(upse).title("Punto Upse").snippet("Marker Description")).showInfoWindow();
                googleMap.addMarker(new MarkerOptions().position(upse2).title("Punto Upse2").snippet("Marker Description")).showInfoWindow();
                googleMap.addMarker(new MarkerOptions().position(upse3).title("Punto Upse3").snippet("Marker Description")).showInfoWindow();
                googleMap.addMarker(new MarkerOptions().position(upse4).title("Punto Upse4").snippet("Marker Description")).showInfoWindow();
                */
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(upse));
                googleMap.animateCamera(CameraUpdateFactory.zoomIn());
                CameraPosition cameraPosition = new CameraPosition.Builder().target(upse).zoom(15).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Intent intent = new Intent(vista.getContext(), RecursoDetalle.class);
                        intent.putExtra("recurso", marker.getTitle());
                        vista.getContext().startActivity(intent);
                        return false;
                    }
                });

            }
        });


        Spinner spinner=(Spinner) vista.findViewById(R.id.spinner_prin_radio);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item=parent.getItemAtPosition(position).toString();
                if (item.equals("Mostrar todos"))
                {
                    // crea todos los markers sin execcion
                    googleMap.clear();
                    googleMap.addMarker(new MarkerOptions().position(upse).title("Punto Upse").snippet("Marker Description"));
                    googleMap.addMarker(new MarkerOptions().position(upse2).title("Punto Upse2").snippet("Marker Description"));
                    googleMap.addMarker(new MarkerOptions().position(upse3).title("Punto Upse3").snippet("Marker Description"));
                    googleMap.addMarker(new MarkerOptions().position(upse4).title("Punto Upse4").snippet("Marker Description"));

                   // Toast.makeText(getActivity(),"todos",Toast.LENGTH_LONG).show();
                }
                if (item.equals("5 kilometros a la redonda"))
                {
                    googleMap.clear();
                    if(distancia_loc_contenidos(loc,upse,5)){
                        googleMap.addMarker(new MarkerOptions().position(upse).title("Punto Upse").snippet("Marker Description")).showInfoWindow();
                    }
                    if(distancia_loc_contenidos(loc,upse2,5)){
                        googleMap.addMarker(new MarkerOptions().position(upse2).title("Punto Upse2").snippet("Marker Description")).showInfoWindow();
                    }
                    if(distancia_loc_contenidos(loc,upse3,5)){
                        googleMap.addMarker(new MarkerOptions().position(upse3).title("Punto Upse3").snippet("Marker Description")).showInfoWindow();
                    }
                    if(distancia_loc_contenidos(loc,upse4,5)){
                        googleMap.addMarker(new MarkerOptions().position(upse4).title("Punto Upse4").snippet("Marker Description")).showInfoWindow();
                    }
                    //googleMap.addMarker(new MarkerOptions().position(upse).title("Punto Upse").snippet("Marker Description")).showInfoWindow();
                   // Toast.makeText(getActivity(),"5KM",Toast.LENGTH_LONG).show();
                }
                if (item.equals("10 kilometros a la redonda"))
                {
                    googleMap.clear();
                    if(distancia_loc_contenidos(loc,upse,10)){
                        googleMap.addMarker(new MarkerOptions().position(upse).title("Punto Upse").snippet("Marker Description")).showInfoWindow();
                    }
                    if(distancia_loc_contenidos(loc,upse2,10)){
                        googleMap.addMarker(new MarkerOptions().position(upse2).title("Punto Upse2").snippet("Marker Description")).showInfoWindow();
                    }
                    if(distancia_loc_contenidos(loc,upse3,10)){
                        googleMap.addMarker(new MarkerOptions().position(upse3).title("Punto Upse3").snippet("Marker Description")).showInfoWindow();
                    }
                    if(distancia_loc_contenidos(loc,upse4,10)){
                        googleMap.addMarker(new MarkerOptions().position(upse4).title("Punto Upse4").snippet("Marker Description")).showInfoWindow();
                    }
                    //Toast.makeText(getActivity(),"10KM",Toast.LENGTH_LONG).show();

                }
                if (item.equals("15 kilometros a la redonda"))
                {
                    googleMap.clear();
                    if(distancia_loc_contenidos(loc,upse,15)){
                        googleMap.addMarker(new MarkerOptions().position(upse).title("Punto Upse").snippet("Marker Description")).showInfoWindow();
                    }
                    if(distancia_loc_contenidos(loc,upse2,15)){
                        googleMap.addMarker(new MarkerOptions().position(upse2).title("Punto Upse2").snippet("Marker Description")).showInfoWindow();
                    }
                    if(distancia_loc_contenidos(loc,upse3,15)){
                        googleMap.addMarker(new MarkerOptions().position(upse3).title("Punto Upse3").snippet("Marker Description")).showInfoWindow();
                    }
                    if(distancia_loc_contenidos(loc,upse4,15)){
                        googleMap.addMarker(new MarkerOptions().position(upse4).title("Punto Upse4").snippet("Marker Description")).showInfoWindow();
                    }
                    //Toast.makeText(getActivity(),"15KM",Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Y lo devolvemos

        return vista;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
        //Log.v("ubicacion resumen", ""+loc.getLongitude() + " - " + loc.getLatitude());
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
        //Log.v("ubicacion pausa", ""+loc.getLongitude() + " - " + loc.getLatitude());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        //Log.v("ubicacion destruir", ""+loc.getLongitude() + " - " + loc.getLatitude());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
        //Log.v("ubicacion memoria", ""+loc.getLongitude() + " - " + loc.getLatitude());
    }

    private void inicLocation(){

        locManager = (LocationManager) getActivity().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

    }

    private void registerLocation(){
        locManager = (LocationManager) getActivity().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        locManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 1000,0,new Fragment_seccion1.MyLocationListener());
    }

    private class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }

        @Override
        public void onProviderEnabled(String provider) {
            loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }

        @Override
        public void onProviderDisabled(String provider) {
            loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
    }

    public boolean distancia_loc_contenidos(Location miUbicacion, LatLng punto, double radio){
        Location instLoc = new Location("punto");
        boolean verificar_distancia = false;
        double distance;
        LatLng point = punto;
        instLoc.setLatitude(point.latitude);
        instLoc.setLongitude(point.longitude);

        //loc es un obejto de tipo Location que guarda mi posición
        distance = miUbicacion.distanceTo(instLoc);
        Log.v("ver cantidad ", ""+distance);
        if((distance/1000) < radio){
            verificar_distancia =true;
            Log.v("ver cantidad ", ""+distance);
        }
        return verificar_distancia;
    }


}
