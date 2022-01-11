package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChanceZhou
 * @create 2021-12-14-10:25
 */
public class JsonTest {

    //1、java 对象和 json 的转换
    @Test
    public void test1() {
        Person person = new Person(1, "ni");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        System.out.println(s);


        Person person1 = gson.fromJson(s, Person.class);
        System.out.println(person1);
    }

    //  2、java 对象 list 集合和 json 的转换
    @Test
    public void test2() {
        List<Person> objects = new ArrayList<>();
        objects.add(new Person(1, "1"));
        objects.add(new Person(2, "2"));

        Gson gson = new Gson();
        String s = gson.toJson(objects);
        System.out.println(s);
        //[{"id":1,"name":"1"},{"id":2,"name":"2"}]

        //有误
        List<Person> list = gson.fromJson(s, objects.getClass());
        System.out.println(list);
        //[{id=1.0, name=1}, {id=2.0, name=2}]


        List<Person> list1 = gson.fromJson(s, new PersonListType().getType());
        System.out.println(list1);
        //[{id=1.0, name=1}, {id=2.0, name=2}]

    }

    // 3、map 对象和 json 的转换
    @Test
    public void test3() {
        HashMap<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "1"));
        personMap.put(2, new Person(2, "2"));

        Gson gson = new Gson();
        String s = gson.toJson(personMap);
        System.out.println(s);

//        HashMap<Integer, Person> personMap2 = gson.fromJson(s, new PersonLMapType().getType());
// 匿名内部类
        Map<Integer, Person> personMap2 = gson.fromJson(s, new TypeToken<HashMap<Integer, Person>>() {
        }.getType());
        System.out.println(personMap2);
        Person person = personMap2.get(1);
        System.out.println(person);

    }
}
