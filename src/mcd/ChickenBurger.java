package mcd;

public class ChickenBurger extends Burger {

    boolean sauce;
    boolean cheese;
    boolean salad;
    boolean chicken;
    String name;

    public ChickenBurger(String name, boolean sauce, boolean cheese, boolean salad, boolean chicken) {
        this.sauce = sauce;
        this.cheese = cheese;
        this.salad = salad;
        this.chicken = chicken;
        this.name = name;
    }

    /*@Override
    public void cook() {
        System.out.println("Cooking chicken burger: ");
        System.out.println("put chicken");
        System.out.println("put salad");
        System.out.println("put sauce");
        System.out.println("put onion");
    }*/

    @Override
    public String toString() {
        return "ChickenBurger{" +
                "name=" + name +
                ", cheese=" + cheese +
                ", salad=" + salad +
                ", chicken=" + chicken +
                ", sauce='" + sauce + '\'' +
                '}';
    }
}
