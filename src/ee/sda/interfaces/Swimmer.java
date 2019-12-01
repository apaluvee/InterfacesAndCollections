package ee.sda.interfaces;

public interface Swimmer {

    //pole vaja public/final panna, sest kõik interfaces on public ja final konstant
    //public final int DEFAULT_SPEED = 20;

    int DEFAULT_SPEED = 20;

    void swim ();

    //can have default
    default double getSwimmingSpeed() {
        return DEFAULT_SPEED;
    }


}
