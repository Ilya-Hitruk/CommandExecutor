package org.marked;

import org.command.executor.annotations.Command;
import org.command.executor.annotations.Param;

@Command("showInfo")
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
        System.out.println(name + " " + age + " " + avgGrade);
    }
}
