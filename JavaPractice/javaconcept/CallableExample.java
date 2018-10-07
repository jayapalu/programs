/**
 * Created by jayapal_uradi on 11/22/17.
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main (String ... args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();

        System.out.println("Calling callable for the factorial 10");
        Future result10 = es.submit(new FactorialCalculator(10));
        System.out.println("Calling get method of future to get factorial 10 --------"+result10.get());

        System.out.println("Calling callable for the factorial 12");
        Future result12 = es.submit(new FactorialCalculator(12));
        System.out.println("Calling get method of future to get factorial 12 --------"+result12.get());


    }
}


class FactorialCalculator implements Callable<Long>  {

    private int number;

    FactorialCalculator(int num) {
        this.number = num;
    }


    @Override
    public Long call() throws Exception {
        return factorial(number);
    }

    private long factorial( int number) throws InterruptedException {

        long result = 1;

        while (number != 0) {

            result = result* number;
            number =number - 1;
            Thread.sleep(10);
        }
        return result;
    }
}