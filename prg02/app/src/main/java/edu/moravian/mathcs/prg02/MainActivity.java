package edu.moravian.mathcs.prg02;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private ListView lvTasks;
    private TasksArrayAdapter tasksArrayAdapter;
    public static final String TASKS_FILE_NAME = "tasks.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lvTasks = (ListView) findViewById(R.id.lvTasks);
        this.tasksArrayAdapter = new TasksArrayAdapter(this, tasksFromFile());
        this.lvTasks.setAdapter(this.tasksArrayAdapter);

        // setup of the itemClickListener
        lvTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final int position = i;
                builder.setMessage(R.string.confirm_delete_task);
                builder.setTitle(R.string.app_name);
                builder.setPositiveButton(R.string.yes_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        tasksArrayAdapter.remove(position);
                        tasksToFile(tasksArrayAdapter.getTasks());
                        tasksArrayAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton(R.string.no_button, null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    private void tasksToFile(List<Task> tasks) {
        try {
            PrintStream out = new PrintStream(openFileOutput(MainActivity.TASKS_FILE_NAME, MODE_PRIVATE));
            for (Task task : tasks)
                out.println(task.getDescription() + "," + new SimpleDateFormat("yyyy-MM-dd").format(task.getDeadline()) + "," + task.getPriority().getValue());
            out.close();
        }
        catch (Exception ex) {
            Log.d("ERROR", ex.getMessage());
        }
    }

    private List<Task> tasksFromFile() {
        Log.d("DEBUG", "on tasksFromFile");
        List<Task> tasks = new ArrayList<>();
        try {
            /*File directory = this.getFilesDir();
            File file = new File(directory, MainActivity.TASKS_FILE_NAME);*/
            Scanner sc = new Scanner(openFileInput(MainActivity.TASKS_FILE_NAME));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Log.d("FILE: ", line);
                String data[] = line.split(",");
                String description = data[0];
                Date deadline = new SimpleDateFormat("yyyy-MM-dd").parse(data[1]);
                Priority priority = Priority.fromInt(Integer.parseInt(data[2]));
                Task task = new Task(description, deadline, priority);
                tasks.add(task);
            }
            sc.close();
        } catch (Exception e) {
            Log.d("ERROR", e.getMessage());
        }
        finally {
            Collections.sort(tasks);
            Log.d("DATA: ", Arrays.toString(tasks.toArray()));
            return tasks;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.tasksArrayAdapter = new TasksArrayAdapter(this, tasksFromFile());
        lvTasks.setAdapter(tasksArrayAdapter);
    }

    void addTask(View view) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }
}
