import java.util.*;

public class TopKFrequentEle {
    public static void main(String[] args){

        int[] nums = {1};
        Set<String> set = new HashSet<>();
        topKfrequent(nums, 1);

    }

    static int[] topKfrequent(int[] nums, int k){

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        Queue<Integer> heap = new PriorityQueue<Integer>( (n1,n2) -> (map.get(n1) - map.get(n2))) ;

        for(int key : map.keySet()) {

            heap.add(key);

            //max heap is created
            if(heap.size() > k) {
                heap.poll();
            }
        }

        //store the elements in array

        int result[] = new int[k];

        for(int i = 0; i<k; i++){
            result[i] = heap.poll();
        }

        System.out.println(Arrays.toString(result));
        return result;
    }
}
