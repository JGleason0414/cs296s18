package edu.moravian.mathcs.list_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Student> listStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listStudents = new ArrayList<>();
        listStudents.add(new Student("johndoe@xyz.com", "John Doe"));
        listStudents.add(new Student("maryjane@xyz.com", "Mary Jane"));
        listStudents.add(new Student("sammaitai@xyz.com", "Sam Mai Tai"));

        ListView lvStudents = (ListView) findViewById(R.id.lvStudents);
        // ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, R.layout.student_list_item, listStudents);
        StudentArrayAdapter studentArrayAdapter = new StudentArrayAdapter(this, listStudents);
        lvStudents.setAdapter(studentArrayAdapter);
    }
}
