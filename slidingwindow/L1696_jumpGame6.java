import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class L1696_jumpGame6 {

    public static void main(String[] args) {

        int[] a = new int[]{10,-5,-7,-4,0,3,6,7,8};
        int k = 3;
        int result = findMaxResult(a, k);
    }

    private static int findMaxResult(int[] a, int k) {

        int score =0;
        int n = a.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((b, c)-> c[0] - b[0]);

        //start from the index 0  and add the current index socre into priority queue.
        //priority queue will sort and give the max score from the previous k values

        //added the first value directly into the pq.
        //score, index
        pq.add(new int[]{a[0],0});

        for(int i=1; i<n; i++) {

            //pop the old index
            System.out.println(Arrays.toString(pq.peek()) + " i-k=  "+(i-k));
            // remove the left most item in the window of k. if the max item on the queue is left most item of the window
            //{10,-5,-7,-4,1,3,6,7,8}, k = 3 .. score are {10,5,3,6,7..} at value 1 index is 4 but the max score is 10 at index 0
            // so we need to delete it because it is going beyond k value.
            while (pq.peek()[1] < i - k) {
                //System.out.println("    Removing " + Arrays.toString(pq.remove()));
                //it will remove the head of the queue
                pq.remove();
            }


            score = a[i] + pq.peek()[0];
            pq.add(new int[]{score, i});
            System.out.println("Score = "+score + " i= "+i);
        }

        return score;
    }
}
