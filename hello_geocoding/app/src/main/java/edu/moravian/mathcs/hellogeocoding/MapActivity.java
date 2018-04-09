package edu.moravian.mathcs.hellogeocoding;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by meotm01 on 4/6/18.
 */

public class MapActivity  extends AppCompatActivity implements OnMapReadyCallback {

    private SupportMapFragment supportMapFragment;
    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // get location parameter and latitude/longitude
        Location location = (Location) getIntent().getSerializableExtra("location");
        latLng = new LatLng(location.getLat(), location.getLng());

        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        FragmentManager fm = getSupportFragmentManager();
        supportMapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
        // use getMapAsync() to register for the map callback:
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker at Moravian College
        // and move the map's camera to the same location.
        Toast.makeText(this, "onMapReady", Toast.LENGTH_LONG).show();
        googleMap.addMarker(new MarkerOptions().position(latLng));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        
    }
}
