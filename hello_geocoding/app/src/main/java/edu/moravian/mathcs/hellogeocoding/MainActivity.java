package edu.moravian.mathcs.hellogeocoding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.*;

public class MainActivity extends AppCompatActivity {

    private String GEOCODING_API_URL = "https://maps.googleapis.com/maps/api/geocode/";
    private String RESPONSE_FORMAT = "json";

    private EditText edtLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLocation = findViewById(R.id.edtLocation);
    }

    public void mapIt(View view) {
        // get parameters for the request and setup the request URL
        String location = edtLocation.getText().toString();
        String requestURL = GEOCODING_API_URL + RESPONSE_FORMAT + "?address=" + location + "&key=" + getString(R.string.geocoding_api_key);
        Log.d("requestURL", requestURL);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, requestURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String str) {
                        Toast.makeText(getBaseContext(), "about to start activity...", Toast.LENGTH_LONG).show();
                        Log.d("RESPONSE: ", str);
                        Gson gson = new Gson();
                        GeocodingResponse response = gson.fromJson(str, GeocodingResponse.class);
                        Result results[] = response.getResults();
                        Geometry geometry = results[0].getGeometry();
                        Location location = geometry.getLocation();
                        Log.d("Location", location.toString());
                        Intent intent = new Intent(getBaseContext(), MapActivity.class);
                        intent.putExtra("location", location);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String message = error.getMessage();
                        Toast.makeText(getBaseContext(), "Error: " + message, Toast.LENGTH_LONG).show();
                    }
                });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
