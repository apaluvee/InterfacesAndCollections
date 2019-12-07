package concurrency;

public class StringPrinter extends Thread {


    //override run method
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+ " : String " + i);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
               // e.printStackTrace();
            }
        }
    }
}
