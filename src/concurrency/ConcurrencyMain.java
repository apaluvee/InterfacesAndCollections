package concurrency;

public class ConcurrencyMain {

    public static void main(String[] args) throws InterruptedException {

        /*Thread t1 = new StringPrinter();
        t1.start();

        System.out.println("Current thread: " + Thread.currentThread().getName());

        Thread.sleep(3000);

        System.out.println("Running");

        Thread.sleep(2000);

        System.out.println("Done");

        */
        Bench bench = new Bench(1);

        Thread st1 = new Thread(new SeatTakerThread(bench));

        Thread st2 = new Thread(new SeatTakerThread(bench));

        st1.start();
        st2.start();


    }

}
