import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement_L215 {
    public static void main(String[] args){

        int[] nums = new int[] {3,2,3,1,2,4,5,6};
        int k = 4;
       // kthLarget(nums,k);
        String [] strs = new String[] {"13", "12","623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"};

        //{"3","6","7","10"};
       System.out.println(kthLargest(strs,11));
    }

    public static int kthLarget(int[] nums, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)->(n1-n2));

        for (int n: nums){
            pq.add(n);

            if(pq.size() > k){
                System.out.println( "   "+pq.poll());
            }
        }

        return pq.poll();
    }

    public static String kthLargest(String[] strs, int k){

        PriorityQueue<String> minHeap = new PriorityQueue<String>((o1,o2)-> {
            if (o1.length() == o2.length()){
                return o1.compareTo(o2);
            }
            return Integer.compare(o1.length(), o2.length());
        });

        for(String str : strs){
            minHeap.add(str);
        }

        while (!minHeap.isEmpty()){
            System.out.println("    "+minHeap.poll());
        }

//        if(minHeap.size() > k) {
//            //System.out.println("    "+heap.poll());
//            minHeap.poll();
//        }

        return String.valueOf(minHeap.poll());

    }
}