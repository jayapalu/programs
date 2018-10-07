import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {


    public static void main (String [] args) {
        System.out.println("This is java executor service example");

        ExecutorService exser = Executors.newFixedThreadPool(3);
        exser.execute(new statusThread());
        exser.execute(new statusThread());
        exser.execute(new statusThread());
        exser.execute(new statusThread());
        exser.execute(new statusThread());

    }

}

class statusThread implements Runnable {

    public void run() {

        System.out.println("This is a print from the thread "+Thread.currentThread().getName());

    }


        }