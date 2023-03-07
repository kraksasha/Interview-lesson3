package Example2;

public class LockExampleRun {
    public static void main(String[] args) throws InterruptedException {
        Counter cr = new Counter();
        for(int i=0; i<200; i++) {
            CounterThread ct = new CounterThread(cr);
            ct.start();
        }
        Thread.sleep(1000);
        System.out.println("counter: " +  cr.getCounter());
    }
}
