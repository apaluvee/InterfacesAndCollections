package io;

import java.util.List;

public class IOMain {

    public static void main(String[] args) {

    Person person = new Person("Tiit", 20, "tel1", "tel2", "tel3");
        System.out.println(person);

        int personAge = person.getAge();
        System.out.println("age " + personAge);

        personAge = 40;
        System.out.println("modified age " + personAge);

        System.out.println("person age is still " + person.getAge());

        List<String> personNumbers = person.getPhoneNumbers();
        System.out.println("phone nrs " + personNumbers);

        //personNumbers.add("tel New nr");

        System.out.println("phone nrs new " + personNumbers);

        System.out.println(person);

        // Helpers:

        // Collections.
        // Arrays.
        // Objects.










    }

}
