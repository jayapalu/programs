import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesinArray_L442 {


    public static void main(String[] args){

        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> result = findAllDuplicateNum(nums);
        System.out.println("duplicate num "+result);

    }

    public static List<Integer> findAllDuplicateNum(int[] nums){

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
        System.out.println("After sor  "+ Arrays.toString(nums));

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i< nums.length; i++){
            if(nums[i] != i+1){
                result.add(nums[i]);
            }
        }

        return result;
    }

    static void swap(int[] nums, int i, int j) {
        // System.out.println("Swapping indexes "+i +" and "+j +" and ele are "+ nums[i] + " and "+ nums[j]);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

