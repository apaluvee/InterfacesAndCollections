package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class IOMain {

    public static void main(String[] args) throws FileNotFoundException, IOException {

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

        /** Input/Output
         *
         * InputStream: get data from somewhere
         * OutputStream: store data to somewhere
         *
         */


        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        inputStream = new FileInputStream("cat.png");
        outputStream = new FileOutputStream("catCopy.png");

        int c = inputStream.read();

        while (c != -1) {
            outputStream.write(c);
        }

        inputStream.close();
        outputStream.close();


    }

}
