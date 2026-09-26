package org.example;

public class Address implements Cloneable{
    String city;
    Address(String City)
    {
        city=City;
    }

    public Address clone()
    {
        try {
            return (Address) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
