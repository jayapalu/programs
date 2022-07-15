import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueueEx {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1);
        PriorityBlockingQueue<Integer> pq = new PriorityBlockingQueue<>();
        producerThread p1 = new producerThread(blockingQueue);
        p1.start();;

        consumerThread c1 = new consumerThread(blockingQueue);
        c1.start();
    }
}



class producerThread extends Thread {

    BlockingQueue<String> blockingQueue;

    producerThread(BlockingQueue<String> q) {
        this.blockingQueue = q;
    }

    public void run() {

        for(int i=0; i<5; i++) {
            try {
                blockingQueue.put("item1-"+i);
                System.out.println("Producer item1-"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

 class consumerThread extends Thread {

     BlockingQueue<String> blockingQueue ;
     consumerThread(BlockingQueue<String> q) {
         this.blockingQueue = q;
     }
    public void run() {
        //dequeue
        for(int i=0; i<5; i++) {
            try {
                String str = blockingQueue.take();
                System.out.println("Consumre "+ str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
 }

