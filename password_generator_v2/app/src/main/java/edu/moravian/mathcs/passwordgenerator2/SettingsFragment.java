package edu.moravian.mathcs.passwordgenerator2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by meotm01 on 4/2/18.
 */

public class SettingsFragment extends Fragment {

    private EditText edtPasswordLength;
    private CheckBox chbIncludeSymbols;
    private CheckBox chbIncludeNumbers;
    private CheckBox chbIncludeLowercase;
    private CheckBox chbIncludeUppercase;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    int getPasswordLength() {
        return Integer.parseInt(edtPasswordLength.getText().toString());
    }

    boolean includeSymbols() {
        return chbIncludeSymbols.isChecked();
    }

    boolean includeNumbers() {
        return chbIncludeNumbers.isChecked();
    }

    boolean includeLowercase() {
        return chbIncludeLowercase.isChecked();
    }

    boolean includeUppercase() {
        return chbIncludeUppercase.isChecked();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // save reference to the view components
        edtPasswordLength = view.findViewById(R.id.edtPasswdLength);
        chbIncludeSymbols = view.findViewById(R.id.chbIncludeSymbols);
        chbIncludeNumbers = view.findViewById(R.id.chbIncludeNumbers);
        chbIncludeLowercase = view.findViewById(R.id.chbIncludeLowercase);
        chbIncludeUppercase = view.findViewById(R.id.chbIncludeUppercase);

        return view;
    }
}
