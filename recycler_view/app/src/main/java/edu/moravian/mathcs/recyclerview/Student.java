package edu.moravian.mathcs.recyclerview;

public class Student {

    private String email;
    private String name;

    public Student(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}