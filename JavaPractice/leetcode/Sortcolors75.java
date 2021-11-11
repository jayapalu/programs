import java.util.Arrays;
import java.util.List;

public class Sortcolors75 {
    public static void main(String[] args ) {

        int[] nums = {0,1,2,0,1,2,0,1,2};
        sortColors(nums);

        /*
        Test cases:
        0,2,2,2,0,2,1,1  - critical
        2,2,0
        0,1,2,0,1,2,0,1,2
        0,1,2,0,2,2,1,0,2

         */

    }

    public static void sortColors(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int ptr = 0;

        while (ptr <= right) {
            System.out.println( " ptr : " +ptr +" ele : "+nums[ptr] + " left : "+ left + " right: "+right) ;

            if(nums[ptr] == 0) {
               System.out.println(" 0 found");
                swap(nums, ptr, left);
                left++;
                System.out.println(" 0 found after swap "+ Arrays.toString(nums) );
            }else if (nums[ptr] == 2) {

                // if there are 2s at the end then move the right
                while( right >= 0 && nums[right] == 2) {
                  right--;
                }

                if(right <= ptr) { // [2,2,0] case
                    continue;
                }

                swap(nums, ptr, right);
                right--;
                System.out.println(" 2 found after swap "+ Arrays.toString(nums));

                if(nums[ptr] == 0 && left != ptr)
                    ptr--; // if there is swap of 0 and 2
                else if (nums[ptr] == 0 && left == ptr){
                    left++;
                }
            }
            ptr++;

        } //while

    } //method

    public static void swap(int[] nums, int ptr, int index) {

        int temp = nums[ptr];
        nums[ptr] = nums[index];
        nums[index] = temp;
    }
}
