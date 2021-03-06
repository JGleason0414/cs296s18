package edu.moravian.mathcs.open_aq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class ResultsActivity extends AppCompatActivity {

    static final String WS_END_POINT = "https://api.openaq.org/v1/cities";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // get country parameter
        Intent intent = getIntent();
        String country = intent.getStringExtra("country");
        String endPoint = WS_END_POINT;
        if (country != null && !country.isEmpty())
            endPoint += "?country=" + country;

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, endPoint,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String str) {
                        Gson gson = new Gson();
                        JSONResponse response = gson.fromJson(str, JSONResponse.class);

                        ListView lvAq = (ListView) findViewById(R.id.lvAq);
                        ArrayAdapter<Result> adapter = new ArrayAdapter<Result>(getBaseContext(), android.R.layout.simple_list_item_1, response.getResults());
                        lvAq.setAdapter(adapter);

                        // Display the first 500 characters of the response string.
                        //mTextView.setText("JSONResponse is: "+ response.substring(0,500));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
