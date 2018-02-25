package edu.moravian.mathcs.list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by meotm01 on 2/25/18.
 */

public class StudentArrayAdapter extends BaseAdapter {

    private List<Student> listStudents;
    private LayoutInflater layoutInflater;
    private Context context;

    public StudentArrayAdapter(Context context, List<Student> listStudents) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.listStudents = listStudents;
    }

    @Override
    public int getCount() {
        return listStudents.size();
    }

    @Override
    public Object getItem(int i) {
        return listStudents.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = layoutInflater.inflate(R.layout.student_list_item, null);
        Student student = listStudents.get(i);
        TextView txvEmail = (TextView) view.findViewById(R.id.txvEmail);
        txvEmail.setText(student.getEmail());
        TextView txvName = (TextView) view.findViewById(R.id.txvName);
        txvName.setText(student.getName());
        return view;
    }
}
