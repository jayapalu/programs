import java.util.concurrent.*;

public class ExecutorEx {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("This is main");

        myTask m1 = new myTask();
        //Thread t1 = new Thread(m1);
        //t1.start();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i=0; i < 3; i++) {
            //executor.submit(new myTask());
            executor.execute(new myTask());
        }

        Future future = executor.submit(new myTask());

        while(!future.isDone()) {
            System.out.println("    Checking Runnable thread STATUS");
            Thread.sleep(1);
        }
        System.out.println("    Runnable thread complete");
       // executor.shutdown();

    }


}

class myTask implements  Runnable {
    @Override
    public void run() {
        System.out.println("THis is my runnable method");
    }
}

class myTaskThread extends Thread {

    @Override
    public void run() {
        System.out.println("THis is my runnable method");
    }
}