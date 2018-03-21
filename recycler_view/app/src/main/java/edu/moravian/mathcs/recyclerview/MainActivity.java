package edu.moravian.mathcs.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

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

        RecyclerView rvStudents = (RecyclerView) findViewById(R.id.rvStudents);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvStudents.setLayoutManager(layoutManager);
        StudentAdapter studentAdapter = new StudentAdapter(this, listStudents);
        rvStudents.setAdapter(studentAdapter);
    }
}
