package edu.moravian.mathcs.prg02;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AddTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Calendar calendar;
    private EditText edtDescription;
    private EditText edtDeadline;
    private Spinner  spnPriority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        // description
        this.edtDescription = (EditText) findViewById(R.id.edtDescription);

        // adjust date to current date
        this.calendar = Calendar.getInstance();
        Date date = this.calendar.getTime();
        this.edtDeadline = (EditText) findViewById(R.id.edtDeadline);
        this.edtDeadline.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
        this.edtDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(AddTaskActivity.this, AddTaskActivity.this, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // priority
        this.spnPriority = (Spinner) findViewById(R.id.spnPriority);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        calendar.set(Calendar.YEAR, datePicker.getYear());
        calendar.set(Calendar.MONTH, datePicker.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
        Date date = this.calendar.getTime();
        this.edtDeadline.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    private int priorityToInt(String priority) {
        if (priority.equals("High"))
            return 2;
        else if (priority.equals("Low"))
            return 0;
        else
            return 1;
    }

    void submit(View view) {
        String description = edtDescription.getText().toString();
        String deadline = edtDeadline.getText().toString();
        String priority = spnPriority.getSelectedItem().toString();

        try {
            PrintStream out = new PrintStream(openFileOutput(MainActivity.TASKS_FILE_NAME, MODE_PRIVATE | MODE_APPEND));
            out.println(description + "," + deadline + "," + priorityToInt(priority));
            out.close();
            finish();
        }
        catch (Exception ex) {
            Log.d("ERROR", ex.getMessage());
        }

    }
}
