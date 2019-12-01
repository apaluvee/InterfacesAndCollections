package ee.sda.interfaces;

public class Person implements Swimmer, Meowable {


    private int age;

    public Person(int age) {
        this.age = age;
    }

    public Person() {

    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
