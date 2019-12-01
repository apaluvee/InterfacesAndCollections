package ee.sda.interfaces;

import java.util.Objects;

public class Book implements Shape, Shape3D, Comparable<Book> {

    //classes: extend
    //interface: implements

    private int width;
    private int length;

    public Book(int width, int length) {
        this.width = width;
        this.length = length;
    }


    //override methods:

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getArea() {
        return width * length;
    }






    //equals ja hash
    @Override
    public boolean equals (Object obj) {

        if (obj instanceof Book) {
            Book book = (Book) obj;

            return  width == book.width && length == book.length;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(width, length);
    }





    //Shape3D
    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public double getVolume() {
        return 0;
    }


    @Override
    public int compareTo(Book otherBook) {
        return (int) (getArea() - otherBook.getArea());
    }


    @Override
    public String toString() {
        return "Book{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}
