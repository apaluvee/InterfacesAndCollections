package mcd;

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
         */




    }
}
