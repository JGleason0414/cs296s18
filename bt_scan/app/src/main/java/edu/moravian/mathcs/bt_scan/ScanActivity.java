package edu.moravian.mathcs.bt_scan;

import android.Manifest;
import android.app.ActionBar;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScanActivity extends AppCompatActivity {

    TextView txvScan;
    BroadcastReceiver bcastReceiver;
    BluetoothAdapter btAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        txvScan = findViewById(R.id.txvScan);

        // bcast receiver
        bcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //Log.d("--->", "ON RECEIVE NOW!!!");
                String action = intent.getAction();
                /*if (action.equals(BluetoothAdapter.ACTION_DISCOVERY_STARTED)) {
                    Log.d("--->", ":discovery started");
                }*/
                if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                    // Log.d("--->", ":device found!!!");
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    //String deviceName = device.getName();
                    String deviceHardwareAddress = device.getAddress(); // MAC address
                    Log.d("--->", deviceHardwareAddress);
                    String text = txvScan.getText().toString();
                    text += deviceHardwareAddress + "\n";
                    txvScan.setText(text);
                }
            }
        };

        // register intent filter
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(bcastReceiver, filter);

        // bluetooth scan
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        btAdapter.startDiscovery();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bcastReceiver);
    }
}

/*

        // linear layout basis
        linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(layoutParams);
        setContentView(linearLayout);


 */
