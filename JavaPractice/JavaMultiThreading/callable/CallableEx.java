package callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//code to run the parallel jobs
public class CallableEx {
    public static  void main(String[] args) {
        System.out.println("Callable Example");


        int[] array = new int[] {1, 2, 3, 4, 5,6,7,8,9};

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer> future =  executor.submit(new addUtil(array, 0, array.length));

        while(!future.isDone()) {
            ;
        }

        try {
            int result = future.get();
            System.out.println("result read from future = "+ result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
