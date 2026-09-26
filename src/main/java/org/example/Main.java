package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static void func1()
    {
        User user=new User();
        Class<?>clazz=User.class;
        Method[]methods=clazz.getMethods();
        for(int i=0;i<methods.length;i++)
        {
            System.out.println(methods[i]);
        }
    }
    private static void func2()
    {
        try {
            User user=new User();
            Class<?>clazz=User.class;
            Method method=clazz.getDeclaredMethod("Say");
            method.invoke(user);
        }
        catch (NoSuchMethodException e)
        {
            System.out.println(e.getMessage());
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    private static void func3()
    {
//        Person<String>p1=new Person<>();
//        p1.user="Gan";
//        System.out.println(p1.user);
//
//        Person<String>p2=new Person<>();
//        p2.user="Hello,World";
//        System.out.println(p2.user);
//
//        Person p3=new Person<>();
//        p3.user="Hello,World";
//        System.out.println(p3.user);
//        p3.user=212;
//        System.out.println(p3.user);
//
//        Person<String>p1=new Person<>();
//        p1.user="ganchuhao";
//        Class<?>clazz=Person.class;
//        try {
//            Method method=clazz.getMethod("Say");
////            System.out.println(method);
//            method.invoke(p1);
//        }
//        catch (NoSuchMethodException e)
//        {
//            System.out.println(e.getMessage());
//        } catch (InvocationTargetException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
    }
    public static void func4(){
        try {
            Class<User>clazz=User.class;
            User user=clazz.getDeclaredConstructor().newInstance();
            Method method=clazz.getMethod("Say");
            method.invoke(user);

            Field field=clazz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(user,"GanChuHao");
            System.out.println(field.get(user));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void func5(User user1)
    {
        user1.name="hello,world";
    }
    public static void func6()
    {
        User user1=new User();
        user1.name="小明";
        User user2=user1.clone();
        user2.name="小红";
        System.out.println(user1.name);
        System.out.println(user2.name);
    }
    public static void main(String[] args) {

    }
}