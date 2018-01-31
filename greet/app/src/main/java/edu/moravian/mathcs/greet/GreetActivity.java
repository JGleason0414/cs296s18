package edu.moravian.mathcs.greet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GreetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet);
    }

    public void greet(View view) {
        // get the reference for the EditText view
        EditText txfName = (EditText) findViewById(R.id.txfName);
        // get the input text from the EditText view object
        String name = txfName.getText().toString();
        // get the reference to the TextView view
        TextView txfGreet = (TextView) findViewById(R.id.txfGreet);
        // update the TextView text
        txfGreet.setText(name);
    }
}
