package org.example;

import java.security.PublicKey;

public class User extends Person{
    public User(String _name,int _age,int _id,String _department)
    {
        name=_name;
        age=_age;
        id=_id;
        department=_department;
    }

    public String name;
    public int age;

    public int GetAge() {
        return age;
    }
}
