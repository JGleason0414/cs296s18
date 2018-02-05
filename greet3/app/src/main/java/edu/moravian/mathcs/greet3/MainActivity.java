package edu.moravian.mathcs.greet3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int STATE_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void greet(View view) {
        // get the reference for the EditText view
        EditText txfName = (EditText) findViewById(R.id.txfName);
        // get the input text from the EditText view object
        String name = txfName.getText().toString();

        // create an explicit intent
        Intent intent = new Intent(this, SecondActivity.class);
        // put data into the intent
        intent.putExtra("name", name);
        // start the second activity specified by the intent
        startActivityForResult(intent, STATE_RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == STATE_RESULT && resultCode == RESULT_OK) {
            String state = data.getStringExtra("state");
            Toast toast = Toast.makeText(this, "You said your are feeling " + state, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
