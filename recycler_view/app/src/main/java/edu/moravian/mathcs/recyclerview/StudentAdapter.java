package edu.moravian.mathcs.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by meotm01 on 3/21/18.
 */

public class StudentAdapter extends RecyclerView.Adapter {

    private List<Student> listStudents;
    private LayoutInflater layoutInflater;

    StudentAdapter(Context context, List<Student> listStudents) {
        this.layoutInflater = LayoutInflater.from(context);
        this.listStudents = listStudents;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.student_list_item, null);
        RecyclerView.ViewHolder studentViewHolder = new StudentViewHolder(view);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("onStudentAdapter", "onBindViewHolder called: position is " + position);
        StudentViewHolder studentViewHolder = (StudentViewHolder) holder;
        TextView txvEmail = studentViewHolder.getTxvEmail();
        TextView txvName = studentViewHolder.getTxvName();
        Student student = listStudents.get(position);
        txvEmail.setText(student.getEmail());
        txvName.setText(student.getName());
    }

    @Override
    public int getItemCount() {
        return listStudents.size();
    }
}
