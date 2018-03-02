package edu.moravian.mathcs.basic_storage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private static final String DATA_FILE_NAME = "data.txt";
    private EditText edtContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get reference to EditText
        edtContents = (EditText) findViewById(R.id.edtContents);

        // open internal storage file
        try {
            Scanner sc = new Scanner(openFileInput(DATA_FILE_NAME));
            String contents = "";
            if (sc.hasNextLine())
                contents = sc.nextLine();
            sc.close();
            edtContents.setText(contents);
        } catch (FileNotFoundException e) {
            // file does not exist or some weird error... ignore it!
        }
    }

    void update(View view) {
        String contents = edtContents.getText().toString();
        try {
            PrintStream out = new PrintStream(openFileOutput(DATA_FILE_NAME, Context.MODE_PRIVATE));
            out.println(contents);
            out.close();
            Toast.makeText(this, "Data file updated!", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            // some weird error... ignore it!
        }
    }
}
