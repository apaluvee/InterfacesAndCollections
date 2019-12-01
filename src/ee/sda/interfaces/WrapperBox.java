package ee.sda.interfaces;

public class WrapperBox implements Shape, Shape3D {

    private static final double boxSize = 2.5;


    @Override
    public double getWidth() {
        return boxSize;
    }

    @Override
    public double getLength() {
        return boxSize;
    }

    @Override
    public double getArea() {
        return boxSize * boxSize;
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
