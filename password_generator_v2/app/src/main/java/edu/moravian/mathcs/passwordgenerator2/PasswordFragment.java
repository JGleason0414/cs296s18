package edu.moravian.mathcs.passwordgenerator2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by meotm01 on 4/2/18.
 */

public class PasswordFragment extends Fragment {

    private EditText edtNewPassword;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    void setNewPassword(String password) {
        if (edtNewPassword != null)
            edtNewPassword.setText(password);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password, container, false);
        edtNewPassword = view.findViewById(R.id.edtNewPassword);
        return view;
    }
}
