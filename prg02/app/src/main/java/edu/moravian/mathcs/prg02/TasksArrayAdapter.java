package edu.moravian.mathcs.prg02;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by meotm01 on 2/25/18.
 */

public class TasksArrayAdapter extends BaseAdapter {

    private List<Task> tasks;
    private LayoutInflater layoutInflater;
    private Context context;

    public TasksArrayAdapter(Context context, List<Task> tasks) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.tasks = tasks;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int i) {
        return tasks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void remove(int i) {
        tasks.remove(i);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = layoutInflater.inflate(R.layout.task_list_item, null);
        Task task = tasks.get(i);
        // priority
        ImageView imgPriority = (ImageView) view.findViewById(R.id.imgPriority);
        Priority priority = task.getPriority();
        if (priority == Priority.LOW)
            imgPriority.setBackgroundResource(R.drawable.ic_priority_low);
        else if (priority == Priority.HIGH)
            imgPriority.setBackgroundResource(R.drawable.ic_priority_high);
        else
            imgPriority.setBackgroundResource(R.drawable.ic_priority_normal);
        // description
        TextView txvDescription = (TextView) view.findViewById(R.id.txvDescription);
        txvDescription.setText(task.getDescription());
        // deadline
        TextView txvDeadline = (TextView) view.findViewById(R.id.txvDeadline);
        txvDeadline.setText(new SimpleDateFormat("yyyy-MM-dd").format(task.getDeadline()));
        return view;
    }
}
