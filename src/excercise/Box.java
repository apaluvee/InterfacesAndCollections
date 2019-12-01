package excercise;

public class Box implements Items{






    @Override
    public void book() {
        System.out.println("Book in box");
    }

    @Override
    public void chair() {
        System.out.println("Chair in box");
    }

    @Override
    public void table() {
        System.out.println("Table in box");
    }
}
