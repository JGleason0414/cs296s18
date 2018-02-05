package edu.moravian.mathcs.wifidata;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String ipFormat(int ip) {
        return String.format("%d.%d.%d.%d", (ip & 0xff), (ip >> 8 & 0xff), (ip >> 16 & 0xff),
                (ip >> 24 & 0xff));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // WiFi state
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        boolean wifiIsOn = wifiManager.isWifiEnabled();
        EditText txfWifi = (EditText) findViewById(R.id.txfWiFi);
        txfWifi.setText(wifiIsOn + "");

        // WiFi configuration
        /*List<WifiConfiguration> wifiConfigurationList = wifiManager.getConfiguredNetworks();
        for (WifiConfiguration wifiConfiguration : wifiConfigurationList) {
            Log.d("debug", wifiConfiguration.SSID);
        }*/

        // SSID
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo == null)
            return;

        EditText txfSSID = (EditText) findViewById(R.id.txfSSID);
        txfSSID.setText(wifiInfo.getSSID());

        // Signal strength
        EditText txfRRSI = (EditText) findViewById(R.id.txfRSSI);
        txfRRSI.setText(wifiInfo.getRssi() + "dBm");

        // Radio frequency
        EditText txfFreq = (EditText) findViewById(R.id.txfFreq);
        txfFreq.setText(wifiInfo.getFrequency() + WifiInfo.FREQUENCY_UNITS);

        // Link Speed
        EditText txfSpeed = (EditText) findViewById(R.id.txfSpeed);
        txfSpeed.setText(wifiInfo.getLinkSpeed() + WifiInfo.LINK_SPEED_UNITS);

        // MAC
        EditText txfMac = (EditText) findViewById(R.id.txfMac);
        txfMac.setText(wifiInfo.getMacAddress());

        // IP
        EditText txfIP = (EditText) findViewById(R.id.txfIP);
        txfIP.setText(ipFormat(wifiInfo.getIpAddress()));
    }
}
