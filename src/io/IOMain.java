package io;

import java.io.*;
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

        try {
            inputStream = new FileInputStream("cat.png");
            outputStream = new FileOutputStream("catCopy.png");

            int c = inputStream.read();

            while (c != -1) {
                outputStream.write(c);
                c = inputStream.read();
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }

            /**need to close the streams always
             *inputStream.close();
             *outputStream.close();
             */
        }

        //FileReader

        FileReader inputReader = null;
        FileWriter outputWriter = null;

        try {
            inputReader = new FileReader("src/input.txt");
            outputWriter = new FileWriter("src/output.txt");

            int c = inputReader.read();

            while (c != -1) {
                outputWriter.write(c);
                System.out.println((char) c);


                c = inputReader.read();
            }

        } finally {
            if (inputReader != null) {
                inputReader.close();
            }
            if (outputWriter != null) {
                outputWriter.close();
            }
        }


        //BufferedStreams

        System.out.println("Buffered: ");

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(
                    new FileReader("src/input.txt")
            );

            String line = bufferedReader.readLine();

            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }






        
    }

}
