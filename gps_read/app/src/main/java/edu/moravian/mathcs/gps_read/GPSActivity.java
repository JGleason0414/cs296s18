package edu.moravian.mathcs.gps_read;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class GPSActivity extends AppCompatActivity {

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        // Location services reading
        final EditText edtProvider = (EditText) findViewById(R.id.edtProvider);
        final EditText edtLongitude = (EditText) findViewById(R.id.edtLongitude);
        final EditText edtLatitude = (EditText) findViewById(R.id.edtLatitude);

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                Log.d("Provider: ", location.getProvider());
                edtProvider.setText(location.getProvider());
                Log.d("GPS Info: ", location.toString());
                edtLongitude.setText("" + location.getLongitude());
                Log.d("Longitude", location.getLongitude() + "");
                edtLatitude.setText("" + location.getLatitude());
                Log.d("Longitude", location.getLatitude() + "");
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }

}
