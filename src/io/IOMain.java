package io;

import com.sun.org.apache.xerces.internal.xs.StringList;
import sun.awt.windows.WBufferStrategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class IOMain {


    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

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
         * InputStream: binary (reads/writes one byte)
         * InputReader: chars (reads/writes one char)
         *
         * BufferedReader/Writer
         * BufferedReader (chars)
         * BufferedWriter (chars)
         * BufferedInputStreams (bytes)
         * BufferedOutputStreams (bytes)
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

        /**
         * Replace try with resources:
         *
         *         BufferedReader bufferedReader = null;
         *
         *         try {
         *             bufferedReader = new BufferedReader(
         *                     new FileReader("src/input.txt")
         *             );
         *
         *             String line = bufferedReader.readLine();
         *
         *             while (line != null) {
         *                 System.out.println(line);
         *                 line = bufferedReader.readLine();
         *             }
         *
         *         } finally {
         *             if (bufferedReader != null) {
         *                 bufferedReader.close();
         *             }
         *         }
         *
         *  :
         */

        System.out.println("Buffered: ");

        List<String> linesFromFile = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/input.txt")
        )) {

            String line = bufferedReader.readLine();

            while (line != null) {
                linesFromFile.add(line);
                System.out.println(line);
                line = bufferedReader.readLine();
            }

        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("output2.txt")
        )) {
            for (String s : linesFromFile) {
                bufferedWriter.write(s);
                bufferedWriter.flush(); //saadab data (filesystem) ja cleanib bufferi
            }
        }


        Scanner scanner = new Scanner(
                new BufferedReader(
                        new FileReader("input2.txt")
                )
        );

        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println("Number from file: " + number);
        }

        /*int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();

        double d = scanner.nextDouble();
        // 11.4
        // 11,4

        String fullLine = scanner.nextLine();

        int intFromLine = Integer.parseInt(fullLine);

        try {
            double doubleFromLine = Double.parseDouble(fullLine);
        } catch (NumberFormatException e) {

        }*/


        BusinessCard businessCard1 = new BusinessCard("Tiit", "+372 100", "tiit@tiit.com");
        //store to file to access later:

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("businessCard.txt")
        )) {
            bufferedWriter.write(businessCard1.getName());
            bufferedWriter.newLine();
            bufferedWriter.write(businessCard1.getPhoneNumber());
            bufferedWriter.newLine();
            bufferedWriter.write(businessCard1.getEmail());
            bufferedWriter.newLine();
        }

        BusinessCard businessCard2 = null;
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("businessCard.txt")
        )) {
            String name = bufferedReader.readLine();
            String phoneNumber = bufferedReader.readLine();
            String email = bufferedReader.readLine();

            businessCard2 = new BusinessCard(name, phoneNumber, email);
        }
        System.out.println(businessCard2);


        //read businessCards with while loop:

        List<BusinessCard> businessCards = new ArrayList<>();

        BusinessCard businessCardTemp = null;
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("businessCards.txt")
        )) {
            while (true) {
                String name = bufferedReader.readLine();
                String phoneNumber = bufferedReader.readLine();
                String email = bufferedReader.readLine();

                if (name == null | phoneNumber == null | email == null) {
                    break;
                }
                businessCardTemp = new BusinessCard(name, phoneNumber, email);
                businessCards.add(businessCardTemp);
            }
        }
        System.out.println(businessCards);


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("businessCardSerialized.txt")
        );

        for (BusinessCard card : businessCards) {
            objectOutputStream.writeObject(card);
        }
        objectOutputStream.writeObject(businessCards);
        objectOutputStream.close();


        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("businessCardSerialized.txt")
        );

        BusinessCard bc = (BusinessCard) objectInputStream.readObject();


        // java.nio.*

        Path path = Paths.get("src/input.txt");
        Path absolutePath = Paths.get("C:\\Users");
        absolutePath = Paths.get("/tmp/anotherFolder/...");

        path.getParent();
        path.getRoot();


        //TODO words count and how many times in nonsense.txt

        Path nonsenseFile = Paths.get("nonsense.txt");
        List<String> allLines = Files.readAllLines(nonsenseFile);

        int totalWords = 0;
        Map<String, Integer> wordCounter = new HashMap<>();

        for (String line : allLines) {
            System.out.println(line);
            String[] words = line.split("\\s");
            System.out.println("words in a line: " + words.length);
            totalWords += (words.length - 1);

            for (String word : words) {

                word = word.toLowerCase().replaceAll("\\W", ""); //\W (a non word character) kõik komad ja punktid ära

                int currentNumberOfWords = wordCounter.getOrDefault(word, 0);
                wordCounter.put(word, currentNumberOfWords + 1);
            }
        }
        System.out.println("Total words: " + totalWords);

        for (Map.Entry<String, Integer> wordCountPair : wordCounter.entrySet()) {
            System.out.println("Word: " + wordCountPair.getKey() + " - " + wordCountPair.getValue() + " times");
        }
    }
}
