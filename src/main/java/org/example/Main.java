package org.example;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//@Slf4j
public class Main {
    //    private static void func1()
//    {
//        User user=new User();
//        Class<?>clazz=User.class;
//        Method[]methods=clazz.getMethods();
//        for(int i=0;i<methods.length;i++)
//        {
//            System.out.println(methods[i]);
//        }
//    }
//    private static void func2()
//    {
//        try {
//            User user=new User();
//            Class<?>clazz=User.class;
//            Method method=clazz.getDeclaredMethod("Say");
//            method.invoke(user);
//        }
//        catch (NoSuchMethodException e)
//        {
//            System.out.println(e.getMessage());
//        } catch (InvocationTargetException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//    }
    private static void func3() {
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

    public static void func4() {
        try {
            Class<User> clazz = User.class;
            User user = clazz.getDeclaredConstructor().newInstance();
            Method method = clazz.getMethod("Say");
            method.invoke(user);

            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(user, "GanChuHao");
            System.out.println(field.get(user));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void func5(User user1) {
        user1.name = "hello,world";
    }

    //    public static void func6()
//    {
//        User user1=new User();
//        user1.name="小明";
//        User user2=user1.clone();
//        user2.name="小红";
//        System.out.println(user1.name);
//        System.out.println(user2.name);
//    }
//    public static void func7()
//    {
//        Person p1=new Person("甘初豪",new Address("北京"));
//        Person p2=p1.clone();
//
//        p2.address.city="上海";
//        System.out.println(p1.address.city);
//        System.out.println(p2.address.city);
//    }
    public static void func8() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("math");
        courses.add("english");
        courses.add("chinese");
        Student s1 = new Student("小明", courses);
        Student s2 = s1.clone();
        s2.courses.set(0, "physic");
//        System.out.println(s1);
        for (int i = 0; i < s1.courses.size(); i++) {
            System.out.println(s1.courses.get(i));
        }
        for (int i = 0; i < s2.courses.size(); i++) {
            System.out.println(s2.courses.get(i));
        }
    }

    public static void func9() {
        List<Integer> numbers = Arrays.asList(8, 5, 1, 9, 10, 15, 23, 11);
        List<Integer> nums = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        for (Integer num : nums) {
            System.out.println(num);
        }
    }

    public static void func() {
        List<User> users = Arrays.asList(
                new User("小明", 10, 2, "研发部"),
                new User("小红", 20, 5, "销售部"),
                new User("小刚", 50, 10, "运营部"),
                new User("小李", 5, 50, "销售部"),
                new User("小天", 90, 60, "研发部"),
                new User("小豆", 2, 1, "研发部"));
        Map<String, Long> UsersOut = users.stream()
                .sorted(Comparator.comparingInt(Person::GetId))
                .collect(Collectors.groupingBy(User::GetDepartment, Collectors.counting()));

        for (Map.Entry<String, Long> item : UsersOut.entrySet()) {
            System.out.println("department:" + item.getKey() + ",id:" + user.id + ",age:" + user.age + ",name:" + user.name);
        }
    }

    public static void main(String[] args) {
        func();
    }
}