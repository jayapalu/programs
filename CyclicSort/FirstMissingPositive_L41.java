import java.util.Arrays;

public class FirstMissingPositive_L41 {

    public static void main(String args[]) {

        int[] nums= new int[] {2,1};

        int res = findFirstMissingPositive(nums);
        System.out.println("Missing positive number is "+res);

    }
    static int findFirstMissingPositive(int[] nums){
        cyclicSortWithCondition(nums);
        System.out.println("Array after sort "+ Arrays.toString(nums));

        for(int i=0; i< nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length;
    }

    static void cyclicSortWithCondition(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            //number should not be -ve numb
            //consider only the numbers till nums.length-1
            //ignore zero, zero is neither positive nor negative
            if (nums[i] > 0 && nums[i] <= nums.length  && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        } //wwhile
    }


    static void swap(int[] nums, int i, int j) {
        // System.out.println("Swapping indexes "+i +" and "+j +" and ele are "+ nums[i] + " and "+ nums[j]);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
