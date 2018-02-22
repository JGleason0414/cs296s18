package edu.moravian.mathcs.list_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, listStudents);
        lvStudents.setAdapter(adapter);

        // setup of the itemClickListener
        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student student = listStudents.get(i);
                Toast toast = Toast.makeText(getBaseContext(), student.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }

}
