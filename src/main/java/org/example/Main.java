package org.example;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static void func10() {
        List<User> users = Arrays.asList(
                new User("小明", 10, 2, "研发部"),
                new User("小红", 20, 5, "销售部"),
                new User("小刚", 50, 10, "运营部"),
                new User("小李", 5, 50, "销售部"),
                new User("小天", 90, 60, "研发部"),
                new User("小豆", 2, 1, "研发部"));
        Map<String, List<Integer>> UsersOut = users.stream()
                .collect(Collectors.groupingBy(User::GetDepartment, Collectors.mapping(User::GetAge, Collectors.toList())));

        for (Map.Entry<String, List<Integer>> item : UsersOut.entrySet()) {
            for (Integer Item : item.getValue()) {
                System.out.println("name:" + item.getKey() + "age:" + Item);
            }
        }
    }

    public static void func11() {
        List<User> users = Arrays.asList(
                new User("小明", 20, 2, "研发部"),
                new User("小红", 20, 2, "销售部"),
                new User("小刚", 50, 10, "运营部"),
                new User("小李", 5, 50, "销售部"),
                new User("小甘", 20, 60, "研发部"),
                new User("小天", 20, 60, "研发部"),
                new User("小豆", 2, 1, "研发部"));
//        Map<String,List<User>>userOut=users.stream().sorted(Comparator.comparingInt(User::GetAge)).collect(Collectors.groupingBy(user -> user.age>=18?"成年":"未成年"));
//        Map<String,List<User>>userOut=users.stream().collect(Collectors.groupingBy(User::GetDepartment));
//        for(Map.Entry<String,List<User>>item:userOut.entrySet())
//        {
//            for(User out:item.getValue())
//            {
//                System.out.println("详情:"+item.getKey()+",DESC:"+out.toString());
//            }
//        }
//        Long ret=users.stream().filter(u->u.id>=10).map(User::GetAge).distinct().count();
//        Long ret= Stream.empty().count();
//        System.out.println(ret);
//        Stream<String>st1=Stream.of("A","B","C");
//        Long ret=st1.count();
//        System.out.println(ret);
//        Stream<Integer> st1=Stream.of(10,20,30,40,50);
////        boolean ret=st1.anyMatch(u->{
////            System.out.println(u);
////            return u>15;
////        });
//        int sum=st1.reduce(0,(a,b)->{
//            int temp=10;
//            return a+b+temp;
//        });
//        Stream<String>st1=Stream.of("name1","name2","name3","name4");
//        String st=st1.reduce("",(before,after)->{
//           return before+":"+after;
//        });
//        System.out.println(st);
//        Stream<String>st1=Stream.of("ABC","DEF","GHI","JKL");
//        Stream<String>st2=Stream.of("ABC","DEF","GHI","JKL");
//
//        Optional<String>op1=st1.reduce((before,after)->before+after);
//        Optional<Integer>ret=Optional.empty();
//        Integer num=ret.orElse(10);
//        System.out.println(num);
//        if(op1.isPresent())
//        {
//            System.out.println(op1.get());
//        }
//        Optional<String>op2=st2.reduce("",(before,after)->before+after);

    }

    public static void expensiveCalculation(Integer num)
    {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName()+":"+num);
    }
    public static void func() {
//        ArrayList<Integer>numbers= new ArrayList<>(List.of(10,15,80,30,20));
//        for(Integer num:numbers)
//        {
//            System.out.println(num);
//        }
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60));
//        numbers.set(2,-10);
//        for(Integer num:numbers)
//        {
//            System.out.println(num);
//        }
        numbers.parallelStream().forEach(n->{
            expensiveCalculation(n);
        });

        numbers.stream().forEach(n->{
            expensiveCalculation(n);
        });
    }

    public static void main(String[] args) {
        func();

    }
}