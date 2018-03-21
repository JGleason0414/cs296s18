package edu.moravian.mathcs.timebasedactivityswitch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txvText;
    private String[] wordBank = { "Apple", "Banana", "Blueberry", "Orange", "Strawberry" };
    private int currentWord = 0;
    private int interval = 2; // seconds
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvText = findViewById(R.id.txvText);
        txvText.setText(wordBank[currentWord]);

        // start a thread
        Runnable r = new Runnable() {
            @Override
            public void run() {
                currentWord++;
                currentWord = currentWord % wordBank.length;
                txvText.setText(wordBank[currentWord]);
                handler.postDelayed(this, interval * 1000);
            }
        };

        handler = new Handler();
        handler.postDelayed(r, interval * 1000);
    }


}
