package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_3Sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>>  res = threeSumZero(nums);
        System.out.println(" Res = " + res);
    }

    static List<List<Integer>> threeSumZero(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println( Arrays.toString(nums));
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates

            int left = i + 1;
            int right = nums.length - 1;

            while( left < right) {

                int target = nums[i] + nums[left] + nums[right];
                if (target == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left = left+1;
                    right = right-1;
                }else if(target < 0) {
                    left = left + 1;
                } else {
                    right = right - 1;
                }
            }
        }
        return result;


    }
}
