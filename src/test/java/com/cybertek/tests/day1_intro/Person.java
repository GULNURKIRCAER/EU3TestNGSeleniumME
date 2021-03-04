package com.cybertek.tests.day1_intro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {

            private int id;
            private String firstName;
            private String lastName;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "id=" + id +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        '}';
            }

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

                Person person3 = new Person();
                person3.setFirstName("Akif");
                person3.setLastName("Mehmet");
                person3.setId(3);
                list.add(person3);

                Person person4 = new Person();
                person4.setFirstName("Sultan");
                person4.setLastName("Yavuz");
                person4.setId(4);
                list.add(person4);

                Person person5 = new Person();
                person5.setFirstName("Fatih");
                person5.setLastName("Yavuz");
                person5.setId(5);
                list.add(person5);

                System.out.println(mapByLastName(list));
            }
    public static Map<String, List<Person>> mapByLastName(List<Person> personList) {

        Map<String, List<Person>> map = new HashMap<>();
        List<Person> list = new ArrayList<>();
        boolean isMatched = false;

        for (Person person : personList) {
            if (map.get(person.getLastName()) == null) {

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
