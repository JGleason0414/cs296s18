package edu.moravian.mathcs.passwordgenerator;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Fragment fragmentSettings, fragmentPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // adjust the layout depending on the orientation
        LinearLayout layout = (LinearLayout) findViewById(R.id.mainActivityLayout);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            layout.setOrientation(LinearLayout.VERTICAL);
        else
            layout.setOrientation(LinearLayout.HORIZONTAL);

        FragmentManager fm = getSupportFragmentManager();
        fragmentSettings = fm.findFragmentById(R.id.settingsContainer);
        if (fragmentSettings == null) {
            fragmentSettings = new SettingsFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.settingsContainer, fragmentSettings);
            ft.commit();
        }
        fragmentPassword = fm.findFragmentById(R.id.passwordContainer);
        if (fragmentPassword == null) {
            fragmentPassword = new PasswordFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.passwordContainer, fragmentPassword);
            ft.commit();
        }
    }

    void generate(View view) {
        int passwordLength = ((SettingsFragment) fragmentSettings).getPasswordLength();
        boolean includeSymbols = ((SettingsFragment) fragmentSettings).includeSymbols();
        boolean includeNumbers = ((SettingsFragment) fragmentSettings).includeNumbers();
        boolean includeLowercase = ((SettingsFragment) fragmentSettings).includeLowercase();
        boolean includeUppercase = ((SettingsFragment) fragmentSettings).includeUppercase();
        String password = Password.generate(passwordLength, includeSymbols, includeNumbers, includeLowercase, includeUppercase);
        ((PasswordFragment)fragmentPassword).setNewPassword(password);
    }
}
