package edu.moravian.mathcs.stop_watch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean  running;
    private int      seconds;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txvWatch = findViewById(R.id.txvWatch);
        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop = findViewById(R.id.btnStop);
        Button btnReset = findViewById(R.id.btnReset);
        if (savedInstanceState != null) {
            running = savedInstanceState.getBoolean("running");
            if (running)
                btnStart.setEnabled(false);
            seconds = savedInstanceState.getInt("seconds");
        }
        else {
            running = false;
            btnStop.setEnabled(false);
            seconds = 0;
        }
    }

    void onClick(View view) {
        Button btn = (Button) view;
        int id = btn.getId();
        switch (id) {
            case R.id.btnStart:
                running = true;
                Button btnStart = findViewById(R.id.btnStart);
                btnStart.setEnabled(false);
                final TextView txvWatch = (TextView) findViewById(R.id.txvWatch);
                final Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        int hours = seconds / 3600;
                        int minutes = (seconds % 3600) / 60;
                        int secs = seconds % 60;
                        String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                        txvWatch.setText(time);
                        if (running)
                            seconds++;
                    });

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int hours = seconds / 3600;
                        int minutes = (seconds % 3600) / 60;
                        int secs = seconds % 60;
                        String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                        txvWatch.setText(time);
                        if (running)
                            seconds++;
                        handler.postDelayed(this, 1000);
                    }
                });
                break;
            case R.id.btnStop:

        }
    }
}
