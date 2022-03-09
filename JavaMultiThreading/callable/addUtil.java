package callable;

import java.util.concurrent.Callable;

public class addUtil implements Callable<Integer> {
    int[] a;
    int start;
    int end;

    addUtil(int[] a, int s, int e) {
        this.a = a;
        this.start = s;
        this.end = e;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Inside call method .....doing addition start = "+this.start + " end= "+this.end);
        int sum=0;
        for(int i=this.start; i< this.end; i++) {
            sum = sum + a[i];
        }
        System.out.println(" Sum inside call = "+ sum);
        return  sum;
    }
}
