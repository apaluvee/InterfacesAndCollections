package ee.sda.interfaces;

import java.util.*;

public class InterfacesMain {

    public static void main(String[] args) {

        Shape[] shapes = new Shape[10];

        for (int i = 0; i < shapes.length; i++) {
            Shape shape;
            if (i % 2 == 0) {
                shape = new WrapperBox();
            } else {
                Random random = new Random();
                shape = new Book(random.nextInt(10) + 1,
                        random.nextInt(20) + 1); //+1 et ei oleks random 0
            }
            shapes[i] = shape;

        }

        for (Shape shape : shapes) {
            System.out.println("Shape: type " + shape.getClass() +
                    " width " + shape.getWidth() +
                    " length " + shape.getLength() +
                    " area " + shape.getArea());
        }

        double totalWidth = 0;
        double totalLength = 0;
        double totalUsedArea = 0;

        for (Shape shape : shapes) {
            totalLength += shape.getLength();
            totalWidth = Math.max(totalWidth, shape.getWidth());
            totalUsedArea += shape.getArea();
        }

        double totalAreaOfContainer = totalLength * totalWidth;
        double effectivelyUsedRatio = totalUsedArea / totalAreaOfContainer;

        System.out.println();
        System.out.println("Total width: " + totalWidth +
                " total length: " + totalLength +
                " total used area: " + totalUsedArea +
                " total area of the container " + totalAreaOfContainer +
                " effectiveness: " + effectivelyUsedRatio);

        System.out.println();

        ////////////


        Person person = new Person();
        person.swim();
        person.meow();

        Cat cat = new Cat();
        cat.meow();

        System.out.println();

        Box boxWithBook = new Box();
        boxWithBook.setItem(new Book(14, 20));
        Book bookFromTheBox = (Book) boxWithBook.getItem();
        System.out.println("Area of the book: " + bookFromTheBox.getArea());


        Box boxWithCat = new Box();
        boxWithCat.setItem(cat);
        Cat catFromTheBox = (Cat) boxWithCat.getItem();
        catFromTheBox.meow();


        Box[] cargo = new Box[3];
        cargo[0] = boxWithBook;
        cargo[1] = boxWithBook;
        cargo[2] = boxWithCat;
        System.out.println(Arrays.toString(cargo));
        System.out.println();

        for (Box currentBox : cargo) {
            Object itemInTheBox = currentBox.getItem();

            if (itemInTheBox instanceof Book) {
                Book b = (Book) itemInTheBox;
                System.out.println("Book area: " + b.getArea());
            } else if (itemInTheBox instanceof Cat) {
                Cat c = (Cat) itemInTheBox;
                c.meow();
            }
        }
        System.out.println();


        //1 item in box
        GenericBox<Book> genericBoxForBook = new GenericBox<>();
        genericBoxForBook.setItem(new Book(3, 7));
        //  genericBoxForBook.setItem(new Cat()); // cat ei saa panna sest diamondi sees on Book
        bookFromTheBox = genericBoxForBook.getItem();
        System.out.println("Area of the book " + bookFromTheBox.getArea());

        //1 item in box
        GenericBox<Cat> genericBoxForCat = new GenericBox<>();
        genericBoxForCat.setItem((new Cat()));
        catFromTheBox = genericBoxForCat.getItem();
        catFromTheBox.meow();

        System.out.println();

        //2 items
        GenericBoxForTwoItems<Book, Cat> genericBoxForTwoItems = new GenericBoxForTwoItems<>();
        genericBoxForTwoItems.setItem(new Book(2, 4));
        genericBoxForTwoItems.setSecondItem(new Cat());
        bookFromTheBox = genericBoxForTwoItems.getItem();
        System.out.println("Area of the book " + bookFromTheBox.getArea());
        catFromTheBox = genericBoxForTwoItems.getSecondItem();
        catFromTheBox.meow();


        //can put anything
        GenericBox<?> boxWithAnything = new GenericBox<>();

        //upper boundary
        GenericBox<? extends Book> boxWithAnyTypeOfBook = new GenericBox();

        //lower boundary
        GenericBox<? super Book> boxWithParentsOfBook = new GenericBox<>();


        /**Collections:
         * List: (ordered), ArrayList (implements list), LinkedList (implements from list and queue)
         *      ArrayList: array
         *      LinkedList: queue ->
         *
         * Queue: (FIFO), PriorityQueue, LinkedList
         *
         * Set: (unordered, no duplications), SortedSet, HashSet, TreeSet
         *
         *
         * Map: (unordered) key, value, HashMap, SortedMap (ordered), TreeMap
         */


        ArrayList<String> shoppingList = new ArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Bread");
        shoppingList.add("Cheese");
        shoppingList.add("Ham");

        System.out.println("Shopping list: " + "totalItems: " + shoppingList.size());

        System.out.println(shoppingList.get(3));
        System.out.println();


        Iterator<String> shoppingListIterator = shoppingList.iterator();


        while (shoppingListIterator.hasNext()) {
            String shoppingItem = shoppingListIterator.next();
            System.out.println("Item: " + shoppingItem);
        }

        System.out.println();

        for (String shoppingItem : shoppingList) {
            System.out.println("For-each loop item: " + shoppingItem);
        }

        //saab removeda 2 viisi
        shoppingList.remove(3);
        shoppingList.remove("Milk");

        System.out.println();

        for (String shoppingItem : shoppingList) {
            System.out.println("Left to buy: " + shoppingItem);
        }

        System.out.println("Need to buy water? " + shoppingList.contains("Water"));
        System.out.println("Need to buy bread? " + shoppingList.indexOf("Bread")); //kui on listis siis index nr
        System.out.println("Need to buy water? " + shoppingList.indexOf("Water")); //kui pole listis siis -1
        System.out.println("Need to buy water? " + (shoppingList.indexOf("Water") > 0));
        System.out.println();


        ///uus list

        ArrayList<String> toDoList = new ArrayList<>();
        toDoList.add("Eat");
        toDoList.add("Sleep");
        toDoList.add("Work");
        toDoList.add("Study");

        for (String toDo : toDoList) {
            System.out.println("To do: " + toDo);
        }
        System.out.println();


        LinkedList<String> testLinkedList = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            testLinkedList.add(0, "Some string");
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Linked list add total time: " + (finishTime - startTime));


        ArrayList<String> testArrayList = new ArrayList<>();
        long startTimeArray = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            testArrayList.add(0, "Some string");
        }
        long finishTimeArray = System.currentTimeMillis();
        System.out.println("Array list add total time: " + (finishTimeArray - startTimeArray));

        System.out.println("------");

        LinkedList<String> newLinkedList = new LinkedList<>();
        newLinkedList.add("Milk");
        newLinkedList.add("Bread");
        newLinkedList.add("Cheese");
        newLinkedList.add("Ham");


        ArrayList<String> newArrayList = new ArrayList<>();
        newArrayList.add("Milk");
        newArrayList.add("Bread");
        newArrayList.add("Cheese");
        newArrayList.add("Ham");


        long startTimeLinkedGet = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            newLinkedList.get(1);
            newLinkedList.get(2);
        }
        long finishTimeLinkedGet = System.currentTimeMillis();
        System.out.println("Linked list Get total time: " + (finishTimeLinkedGet - startTimeLinkedGet));


        long startTimeArrayGet = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            newArrayList.get(1);
            newArrayList.get(2);
        }
        long finishTimeArrayGet = System.currentTimeMillis();
        System.out.println("Array list Get total time: " + (finishTimeArrayGet - startTimeArrayGet));

        System.out.println("------");

        long startTimeLinkedRemove = System.currentTimeMillis();
        for (int i = newLinkedList.size() - 1; i >= 0; i--) {
            newLinkedList.remove(i);
        }
        long finishTimeLinkedRemove = System.currentTimeMillis();
        System.out.println("Linked list Remove total time: " + (finishTimeLinkedRemove - startTimeLinkedRemove));


        long startTimeArrayRemove = System.currentTimeMillis();
        for (int i = newArrayList.size() - 1; i >= 0; i--) {
            newArrayList.remove(i);
        }
        long finishTimeArrayRemove = System.currentTimeMillis();
        System.out.println("Array list Remove total time: " + (finishTimeArrayRemove - startTimeArrayRemove));


        System.out.println("------");

        LinkedList<String> waitingList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            waitingList.addLast("Person " + i);
        }

        while (!waitingList.isEmpty()) {
            String personToService = waitingList.poll();
            System.out.println(personToService + " serviced");
        }

        //priority Queue

        PriorityQueue<Person> personPriorityQueue = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {

                boolean firstPensioner = o1.getAge() > 65;
                boolean secondPensioner = o2.getAge() > 65;

                if (firstPensioner && secondPensioner) {
                    return 0;
                }

                if (firstPensioner && !secondPensioner) {
                    return -1;
                }

                if (!firstPensioner && secondPensioner) {
                    return 1;
                }

                if (!firstPensioner && !secondPensioner) {
                    return 0;
                }

                return 0;
            }
        });

        personPriorityQueue.add(new Person(30));
        personPriorityQueue.add(new Person(75));
        personPriorityQueue.add(new Person(15));
        personPriorityQueue.add(new Person(66));
        personPriorityQueue.add(new Person(20));

        while (!personPriorityQueue.isEmpty()) {
            Person servicedPerson = personPriorityQueue.poll();
            System.out.println("Serviced Person of age " + servicedPerson.getAge());
        }


        System.out.println();

        /**
         *
         * Set. unordered collection. no duplicates
         *
         */

        HashSet<String> visitedCities = new HashSet<>();
        visitedCities.add("Tartu");
        visitedCities.add("Tallinn");
        visitedCities.add("Narva");
        visitedCities.add("Rapla");
        visitedCities.add("Narva");
        visitedCities.add("Valga");

        for (String city : visitedCities) {
            System.out.println("Visited: " + city + ".");
        }

        System.out.println("------");
        visitedCities.remove("Rapla");
        visitedCities.remove("Narva");

        for (String city : visitedCities) {
            System.out.println("Visited: " + city + ".");
        }
        System.out.println("------");


        //2 objekti erineva nimega: book1 ja book3 on equal, sest väärtused samad
        Book book1 = new Book(12, 15);
        Book book2 = new Book(25, 33);
        Book book3 = new Book(12, 15);

        System.out.println("Equals? " + book1.equals(book2));
        System.out.println("Equals? " + book1.equals(book3));

        System.out.println("------");

        Set<Book> readBooks = new HashSet<>();
        readBooks.add(book1);  //book1 ja book3 on equal
        readBooks.add(book2);
        readBooks.add(book1);
        readBooks.add(book3);

        for (Book readBook : readBooks) {
            System.out.println("Read: " + readBook + ".");
        }
        System.out.println("------");

        /**
         *
         * Map
         *
         */

        HashMap<Book, String> booksAuthorsMap = new HashMap<>();

        booksAuthorsMap.put(new Book(12, 23), "Author A");
        booksAuthorsMap.put(new Book(5, 12), "Author B");
        booksAuthorsMap.put(new Book(18, 10), "Author C");
        booksAuthorsMap.put(new Book(3, 5), "Author B");
        booksAuthorsMap.put(new Book(23, 30), "Author C");

        for (Book booksFromMap : booksAuthorsMap.keySet()) {
            System.out.println("Book from map: " + booksFromMap);
        }

        for (String authorFromMap : booksAuthorsMap.values()) {
            System.out.println("Author from map: " + authorFromMap);
        }

        for (Map.Entry<Book, String> bookAuthor : booksAuthorsMap.entrySet()) {
            System.out.println("Mapping: book " + bookAuthor.getKey() + " -> author " + bookAuthor.getValue());
        }

        System.out.println("Author of 12x23 is " + booksAuthorsMap.get(new Book(12,23)));

        System.out.println("Author of 1x23 is " + booksAuthorsMap.get(new Book(1,23))); // kui pole siis: null

        System.out.println("Author of 1x2 is " + booksAuthorsMap.getOrDefault(new Book(1,2),"Unknown Author"));


         //TODO TreeSet
         //TODO TreeMap





    }


}
