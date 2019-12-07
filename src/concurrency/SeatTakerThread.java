package concurrency;

public class SeatTakerThread implements Runnable{

    private Bench bench;

    public SeatTakerThread(Bench bench) {
        this.bench = bench;
    }

    @Override
    public void run() {
        bench.takeSeat();
    }
}
