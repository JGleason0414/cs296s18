package edu.moravian.mathcs.open_aq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void go(View view) {
        EditText edtCountry = (EditText) findViewById(R.id.edtCountry);
        String country = edtCountry.getText().toString();
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra("country", country);
        startActivity(intent);
    }
}
