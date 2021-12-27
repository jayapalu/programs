import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMisMatch_L645 {

    //cyclic sort with missing and duplicate num
    public static  void main(String[] args) {

        int[] nums = new int[]{4,2, 1, 7, 2, 5, 6};
        int[] result = findDuplicateAndMissing(nums);
        System.out.println("duplicate num " + Arrays.toString(result));

    }

    public static int[] findDuplicateAndMissing(int[] nums){

        int index = 0;
        while(index < nums.length) {
            int correct = nums[index] - 1;
            if (nums[index] != nums[correct]) {
                //swap
                swap(nums, index, correct);
            } else {
                index++;
            }
        }
        System.out.println("After sort  "+ Arrays.toString(nums));

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i< nums.length; i++){
            if(nums[i] != i+1){
                return new int[]{nums[i], i+1};
            }
        }

        return new int[0];
    }

    static void swap(int[] nums, int i, int j) {
        // System.out.println("Swapping indexes "+i +" and "+j +" and ele are "+ nums[i] + " and "+ nums[j]);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
