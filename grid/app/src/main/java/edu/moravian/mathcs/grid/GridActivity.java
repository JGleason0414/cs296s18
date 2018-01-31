package edu.moravian.mathcs.grid;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
    }

    public void onClick(View view) {
        Button btn = (Button) view;
        String text = btn.getText().toString();
        Toast toast = Toast.makeText(this, text + " was clicked!", Toast.LENGTH_LONG);
        toast.show();
    }
}
