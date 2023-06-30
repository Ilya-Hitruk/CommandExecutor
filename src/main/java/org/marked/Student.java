package org.marked;

import org.command.executor.annotations.Command;
import org.command.executor.annotations.Param;

@Command("Student")
public class Student implements Runnable {

    public Student() {
    }

    @Param("name")
    private String name;

    @Param("age")
    private int age;

    @Param("avgGrade")
    private double avgGrade;

    @Override
    public void run() {
        showInfo();
    }

    public void showInfo() {
        System.out.println(name + " " + age + " " + avgGrade);
    }
}
