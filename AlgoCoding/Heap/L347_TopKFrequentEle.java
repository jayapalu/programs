import java.util.*;

public class L347_TopKFrequentEle {
    public static void main(String[] args){

        int[] nums = {2,2,2,5,5,7,8,9,10,11};
        Set<String> set = new HashSet<>();
        topKfrequent(nums, 3);

    }

    static int[] topKfrequent(int[] nums, int k){

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i=0; i< nums.length; i++){
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0)+1);
        }

        Queue<Integer> heap = new PriorityQueue<Integer>( (n1,n2) -> (frequencyMap.get(n1) - frequencyMap.get(n2))) ;

        for(int key : frequencyMap.keySet()) {

            heap.add(key);

            //max heap is created
            if(heap.size() > k) {
                System.out.println("removing "+ heap.peek() + " with freq "+ frequencyMap.get(heap.peek()));
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
