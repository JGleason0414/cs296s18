package edu.moravian.mathcs.bt_scan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void scan(View view) {
        Intent intent = new Intent(this, ScanActivity.class);
        startActivity(intent);
    }

}
