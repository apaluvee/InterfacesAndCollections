package ee.sda.interfaces;

public class Book implements Shape, Shape3D {

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



    //Shape3D
    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public double getVolume() {
        return 0;
    }
}
