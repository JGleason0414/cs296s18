package edu.moravian.mathcs.greet4;

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

    public void greet(View view) {
        EditText txfName = (EditText) findViewById(R.id.txfName);
        String name = txfName.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, name);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hello");
        startActivity(intent);
    }
}
