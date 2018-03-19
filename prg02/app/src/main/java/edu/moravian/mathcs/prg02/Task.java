package edu.moravian.mathcs.prg02;

import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by meotm01 on 2/25/18.
 */

public class Task implements Comparable<Task> {

    private String   description;
    private Date     deadline;
    private Priority priority;

    public Task(String description, Date deadline, Priority priority) {
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", deadline=" + deadline +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(@NonNull Task task) {
        return task.getPriority().getValue() - this.getPriority().getValue();
    }
}
