package ee.sda.interfaces;

import java.util.Arrays;
import java.util.Random;

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
            } else if (itemInTheBox instanceof Cat){
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
        genericBoxForTwoItems.setFirstItem(new Book(2,4));
        genericBoxForTwoItems.setSecondItem(new Cat());
        bookFromTheBox = genericBoxForTwoItems.getFirstItem();
        System.out.println("Area of the book " + bookFromTheBox.getArea());
        catFromTheBox = genericBoxForTwoItems.getSecondItem();
        catFromTheBox.meow();
    }




}
