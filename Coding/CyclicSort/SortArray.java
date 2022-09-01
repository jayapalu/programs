import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        // here the array elements are from 1 to n. Hence in leaner time sorting.
        int[] nums = new int[]{3,0,1 };

        //sortArray(nums);
       // sortMissingnumberArray(nums);
        int missingnum = findMissingNum(nums);
        System.out.println("after sort "+ Arrays.toString(nums));
        System.out.println("missing number "+  missingnum);
    }

    static void sortArray(int[] nums){

        int size = nums.length;
        int index = 0;
        while ( index < size ){
            //check
            if(nums[nums[index] - 1] != nums[index]){
                System.out.println("Number NOT in correct place "+nums[index] +" index="+index);
                //swap
                swap(nums, index, nums[index]-1);
            }else {
                System.out.println("Number is in correct place "+nums[index] +" index="+index);
                //increment the i;
                index++;
            }
        }
    }

    static int findMissingNum(int[] nums) {
        sortMissingnumberArray(nums);
        for(int i=0; i<nums.length; i++){
            if(i != nums[i]) {
                return i;
            }
        }
        //if all the nums are present then missing number is n
        return nums.length;
    }

    static void sortMissingnumberArray(int[] nums){
        int size = nums.length;
        int index = 0;
        //index should be incremented only if the element is in correct position
        while(index<size){
            //check
            if (nums[index] < size && nums[nums[index]] != nums[index]) {
                System.out.println("Number NOT in correct place, num= " + nums[index] + " index=" + index);
                //swap
                swap(nums, index, nums[index]);
            } else {
                //increment the index;
                System.out.println("Number is in correct place " + nums[index] + " index=" + index);
                index++;
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
