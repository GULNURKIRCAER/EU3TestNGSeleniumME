package com.cybertek.tests.day1_intro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class new7 {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<Person>();
        Person person = new Person();
        person.setFirstName("Emre");
        person.setLastName("Mehmet");
        person.setId(1);
        list.add(person);

        Person person2 = new Person();
        person2.setFirstName("Ali");
        person2.setLastName("Mehmet");
        person2.setId(2);
        list.add(person2);

        System.out.println(mapByLastName(list));
    }
    public static Map<String, List<Person>> mapByLastName(List<Person> personList) {

        Map<String, List<Person>> map = new HashMap<>();

        boolean isMatched = false;

        for (Person person : personList) {
            if (map.get(person.getLastName()) == null) {
                List<Person> list = new ArrayList<>();
                list.add(person);
                map.put(person.getLastName(), list);
            }else {
                for (Person p : map.get(person.getLastName())) {
                    if (p.getId() == person.getId()) {
                        isMatched = true;
                        break;
                    }
                }
                if (!isMatched) {
                    map.get(person.getLastName()).add(person);
                }
            }
        }

        return map;

    }
}
