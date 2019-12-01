package ee.sda.interfaces;

public class Person implements Swimmer, Meowable {


    @Override
    public void swim() {
        System.out.println("I'm swimming");

    }

    @Override
    public double getSwimmingSpeed() {
        return 40;
    }

//////////////////////////
    @Override
    public void meow() {
        System.out.println("I'm meowing");
    }
}
