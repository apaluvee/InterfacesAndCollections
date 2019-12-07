package io;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {

    private String name;

    private int age;

    private List<String> phoneNumbers = new ArrayList<>();


    public Person(String name, int age, String... phoneNumbers) {
        this.name = name;
        this.age = age;

        for (String phoneNumber : phoneNumbers) {
            this.phoneNumbers.add(phoneNumber);
        }
    }

    public List<String> getPhoneNumbers() {
        return Collections.unmodifiableList(phoneNumbers); //et ei saaks listi muuta
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
