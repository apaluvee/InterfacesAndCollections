package concurrency;

public class Bench {

    private int seatsAvailable;

    public Bench(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public synchronized void takeSeat() { //synchronized: 1 thread korraga
        if (seatsAvailable > 0) {
            System.out.println("seats available: " + seatsAvailable);
            seatsAvailable--;
            System.out.println("seats left: " + seatsAvailable);
        } else {
            System.out.println("no seats left");
        }
    }

    /*synchronized (this) {
        //code block
    }*/

}
