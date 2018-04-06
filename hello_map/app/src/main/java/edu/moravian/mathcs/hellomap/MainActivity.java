package edu.moravian.mathcs.hellomap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapView = findViewById(R.id.mapView);
        MapsInitializer.initialize(this);
        LatLng moco = new LatLng(-75.381203, 40.630890);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(moco, 10);
        map.animateCamera(cameraUpdate);


        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("onMapReady", "");
        LatLng moco = new LatLng(-75.381203, 40.630890);
        googleMap.addMarker(new MarkerOptions().position(moco)
                .title("Moravian College"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(moco));
    }
}
