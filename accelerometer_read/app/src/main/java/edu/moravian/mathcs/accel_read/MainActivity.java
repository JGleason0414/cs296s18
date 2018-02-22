package edu.moravian.mathcs.accel_read;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void btnClicked(View view) {
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Button btn = (Button) view;
        if (btn.getText().toString().equals("Start")) {
            btn.setText("Stop");
            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        }
        else {
            btn.setText("Start");
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float values[] = sensorEvent.values;
        EditText edtX = (EditText) findViewById(R.id.edtX);
        edtX.setText("" + values[0]);
        EditText edtY = (EditText) findViewById(R.id.edtY);
        edtY.setText("" + values[1]);
        EditText edtZ = (EditText) findViewById(R.id.edtZ);
        edtZ.setText("" + values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        Button btn = (Button) findViewById(R.id.btnStartStop);
        btn.setText("Start");
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
    }
}
