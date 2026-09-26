package org.example;

public class User implements Cloneable{
    public User clone()
    {
        try {
            return (User) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public String name;
}
