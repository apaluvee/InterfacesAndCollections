package ee.sda.interfaces;

public class Cat implements Meowable {


    @Override
    public void meow() {
        System.out.println("Cat is meowing");
    }
}
