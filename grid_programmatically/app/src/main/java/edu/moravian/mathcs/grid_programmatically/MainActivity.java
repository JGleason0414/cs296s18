package edu.moravian.mathcs.grid_programmatically;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int COLS = 5;
    static final int ROWS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // grid layout
        GridLayout gridLayout = new GridLayout(this);

        gridLayout.setColumnCount(COLS);
        gridLayout.setRowCount(ROWS);

        // buttons
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++) {
                final Button btn = new Button(this);
                GridLayout.LayoutParams param = new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED, 1f), GridLayout.spec(GridLayout.UNDEFINED, 1f));
                btn.setLayoutParams(param);
                btn.setText(i + "," + j);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast toast = Toast.makeText(getBaseContext(), btn.getText().toString() + " was clicked!", Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
                gridLayout.addView(btn);
            }

        setContentView(gridLayout);
    }
}
