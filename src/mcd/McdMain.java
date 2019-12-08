package mcd;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class McdMain {

    public static void main(String[] args) {

        //Burger chickenBurger = new ChickenBurger("Chicken Burger", true,true,false, true);
        //System.out.println(chickenBurger);

        Burger fishBurger = new FishBurger();
        fishBurger.cook(new CookCheeseOperation(), new CookFishOperation());

        Operation rawFishOperation = () -> System.out.println("put raw fish to burger");  //lambda expression, () one method: execute (from Operation)

        System.out.println("Cooking burger with raw fish operation: ");
        fishBurger.cook(new CookCheeseOperation(), rawFishOperation);


        /**
         * Parameterise: variables (functions), classes (generics), methods (functional interfaces)
         *
         *
         *
         */

        //Function = one argument -> do something
        Function<String, Integer> lengthOfWord = (word) -> word.length();
        System.out.println(lengthOfWord.apply("Programming"));

        //Consumer = one argument -> returns void(doesn't return anything)
        Consumer<String> stringPrinter = (string) -> System.out.println(string);
        stringPrinter.accept("Test print");

        //Supplier = no parameters -> return something
        Supplier<Integer> generatedInteger = () -> new Random().nextInt(10);
        System.out.println(generatedInteger.get());

        //Predicate = one argument -> return boolean
        Predicate<Integer> isAdult = (age) -> age >= 18;
        System.out.println(isAdult.test(20));
        System.out.println(isAdult.test(15));

        //UnaryOperator = one argument -> returns value of same type
        UnaryOperator<Integer> numberSquare = (number) -> number * number;
        System.out.println(numberSquare.apply(3));

        //BinaryOperator = two parameters -> returns same type
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(4, 8));


        BinaryOperator<Integer> sumWithDebug = (a, b) -> {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            return a + b;
        };
        System.out.println(sumWithDebug.apply(9, 134));


        Function<String, Integer> stringLength = String::length;
        System.out.println("Sting length: " + stringLength.apply("Programming Course"));


        System.out.println("Todo: ");
        //TODO subtraction, multiplication, division
        BinaryOperator<Integer> sub = (a, b) -> a - b;
        System.out.println(sub.apply(4, 8));

        BinaryOperator<Integer> multiplication = (a, b) -> a * b;
        System.out.println(multiplication.apply(4, 2));

        BinaryOperator<Integer> division = (a, b) -> a / b;
        System.out.println(division.apply(4, 2));


        //TODO sum of the elements in List<Integer>
        List<Integer> elements = new ArrayList<>();
        elements.add(5);
        elements.add(10);

        Function<List<Integer>, Integer> sumOfList = (someList) -> {
            int sumOfNumbers = 0;
            for (Integer number : elements) {
                sumOfNumbers += number;
            }
            return sumOfNumbers;
        };
        System.out.println(sumOfList.apply(elements));


        //TODO number of words in a string
        //1:
        Function<String, Integer> numberOfWords = (string) -> {
            String[] wordArray = string.split("\\s");
            return wordArray.length;
        };
        System.out.println(numberOfWords.apply("one two three"));

        //2:
        Function<String, Integer> numberOfWords2 = (string) -> string.split("\\s").length;
        System.out.println(numberOfWords2.apply("one two three four"));

        /**
         * Regex:
         * \\s - space char
         * \\d - digits
         * \\D - not digits
         * \\w - word char
         * \\W - not word char
         */

        System.out.println();

        String name = null;
        //System.out.println("Name length: " + name.length());

        //Optional: 1st case (Exception), 2nd case (can be null)

        //Optional<String> optionalName = Optional.of(name);
        Optional<String> optionName2 = Optional.ofNullable(name);
        if (optionName2.isPresent()) {
            System.out.println(optionName2.get());
        }

        optionName2.ifPresent((n) -> System.out.println(n));
        optionName2.orElse("default name");
        optionName2.orElseGet(() -> generatedInteger + "");
        //optionName2.orElseThrow(() -> new RuntimeException());


        List<Integer> numbers = Arrays.asList(2, 6, 4, 8, 0, 9);
        //int result = numbers.stream().filter((number) -> number > 20).sorted().findFirst().get();
        //System.out.println("min > 20: " + result);

        /**
         *
         *
         *
         */


        // all the elements are greater than 20
        numbers.stream().allMatch((x) -> x > 20);

        // at least one element greater than 20
        numbers.stream().anyMatch((x) -> x > 20);

        // number of elements
        numbers.stream().count();

        List<Integer> numbers2 = Arrays.asList(12, 50, 30, -23, 12, 50);
        //create one stream ouf of 2
        Stream.concat(numbers.stream(), numbers2.stream());

        //unique values (remove duplicate)
        numbers2.stream().distinct();

        //filter
        numbers2.stream().filter((x) -> x > 20);

        //limit 3 first values
        numbers2.stream().limit(3);

        //skip first 5 values, start from 6th
        numbers2.stream().skip(5);

        //sorted
        numbers2.stream().sorted((o1, o2) -> o2 - o1);

        //map: substitute one value with another
        numbers2.stream().map((x) -> x * x);

        //collect: convert from stream to a collection
        List<Integer> integerList = numbers2.stream().collect(Collectors.toList());


        //TODO
        List<String> names = Arrays.asList("Alice", "Maarja", "Teet", "Bob", "Juhan", "Evelyn", "Eve");

        //1. Print only names that start with E
        //2. Print names UpperCase
        //3. remove first and last letter, sort and print

        String namesResult = names.stream().filter((nameWithE) -> nameWithE.startsWith("E")).collect(Collectors.joining(", "));
        System.out.println(namesResult);

        // names.stream().forEach((s) -> System.out.println(s.toUpperCase()));

        List<String> upperCaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseNames);

        List<String> removedLetters = names.stream().map((s) -> s.substring(1, s.length() - 1)).sorted().collect(Collectors.toList());
        System.out.println(removedLetters);


        //word = word.toUpperCase()


    }
}
