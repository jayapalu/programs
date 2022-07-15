import java.util.concurrent.*;

public class CallableEx {

    public static void main(String[] args) {

        //Thread t1 = new Thread(new myCallable(5,6));
        ExecutorService exs= Executors.newFixedThreadPool(1);

        Future<Integer> future =  exs.submit(new myCallable(5,6));

        while(!future.isDone()) {
            //wait
        }

        try {
            int res = future.get();
            System.out.println(" Result is "+ res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

 class myCallable implements Callable<Integer> {

    int x;
    int y;

    myCallable(int a, int b) {
        this.x = a;
        this.y = b;
    }
     @Override
     public Integer call() throws Exception {
         System.out.println(" Inside call x= "+ x + " y= "+y) ;
         return x + y;
     }
 }
