package edu.moravian.mathcs.list_view;

/**
 * Created by meotm01 on 2/14/18.
 */

public class Student {

    private String email;
    private String name;

    public Student(String email, String name) {
        this.email = email;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
