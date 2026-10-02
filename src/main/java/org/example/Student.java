package org.example;

import java.util.ArrayList;

public class Student implements Cloneable{
    public String name;
    public ArrayList<String>courses;
    Student(String name,ArrayList<String>courses)
    {
        this.name=name;
        this.courses=courses;
    }

    @Override
    public Student clone()
    {
        try {
            Student copy=(Student) super.clone();
            copy.courses=new ArrayList<>(this.courses);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
