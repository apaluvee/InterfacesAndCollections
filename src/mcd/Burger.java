package mcd;

public class Burger {

    public void cook(Operation... operations) {
        for (Operation operation : operations) {
            operation.execute();
        }

    }

}
