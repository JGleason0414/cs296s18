package edu.moravian.mathcs.greet3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // get the intent
        Intent intent = getIntent();
        // get the data from the intent
        String name = intent.getStringExtra("name");
        // get the reference to the TextView view
        TextView txfGreet = (TextView) findViewById(R.id.txfGreet);
        // update the TextView text
        txfGreet.setText("Hello " + name);
    }

    public void state(View view) {
        // get the reference for the EditText view
        EditText txfState = (EditText) findViewById(R.id.txfState);
        // get the input text from the EditText view object
        String state = txfState.getText().toString();

        // finish the activity with result
        Intent replyIntent = new Intent();
        replyIntent.putExtra("state", state);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
