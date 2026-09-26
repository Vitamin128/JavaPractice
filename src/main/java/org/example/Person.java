package org.example;

public class Person implements Cloneable
{
    Address address;
    String name;
    Person(String name,Address address)
    {
        this.name=name;
        this.address=address;
    }

    @Override
    public Person clone()
    {
        try {
            Person copy= (Person) super.clone();
            copy.address=(Address) address.clone();
            return copy;
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
