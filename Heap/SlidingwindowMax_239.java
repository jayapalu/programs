import javafx.scene.layout.Priority;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingwindowMax_239 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, 3, 5, 3, 6, 7};
        //{1,2}

        int[] res = slidingwindowMax(nums, 3);
        System.out.println(Arrays.toString(res));

    }

    public static int[] slidingwindowMax(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] result = new int[nums.length - k + 1];
        int j = 0;

        int start = 0;
        int end = 0;

        while (end < nums.length) {
            maxHeap.add(nums[end]);
            if ((end + 1) >= k) {
                int max = maxHeap.peek();
                System.out.println(max);
                result[j++] = max;

                maxHeap.remove(nums[start]);
                start++;
            }
            end++;
        } //while

        return result;

    }

    public static int[] slidingwindowMaxOptimized(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] result = new int[nums.length - k + 1];
        int j = 0;

        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;

        while (end < nums.length) {


            if (end - start == k && nums[end] > max) {
                System.out.println("end-start = k");
                start = end;

            }
            maxHeap.add(nums[end]);
            if ((end + 1) >= k) {
                max = maxHeap.peek();
                System.out.println(max);
                result[j++] = max;

                maxHeap.remove(nums[start]);
                start++;
            }
            end++;
        } //while

        return result;
    }
}
