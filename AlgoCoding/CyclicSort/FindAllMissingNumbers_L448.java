import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllMissingNumbers_L448 {
    public static void main(String[] args){
        int[] nums = new int[]{1,3,4,2,2};
        List<Integer> list = findMissingNums(nums);

        System.out.println(list);

    }

    static List<Integer> findMissingNums(int[] nums) {
        List<Integer> list = new ArrayList<>();
        sortMissingnumberArray(nums);
        System.out.println("After sort"+ Arrays.toString(nums));
        for(int i=0; i<nums.length; i++){
            if(i+1 != nums[i]) {
                list.add(i+1);
            }
        }
        return  list;
    }

    static void sortMissingnumberArray(int[] nums){
        int size = nums.length;
        int index = 0;
        //index should be incremented only if the element is in correct position
        while(index<size){
            //check
            if (nums[index] != nums[nums[index]-1]) {
                System.out.println("Number NOT in correct place, num= " + nums[index] + " index=" + index);
                //swap
                swap(nums, index, nums[index]-1);
            } else {
                //increment the index;
                System.out.println("Number is in correct place " + nums[index] + " index=" + index);
                index++;
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        System.out.println("Swapping indexes "+i +" and "+j +" and ele are "+ nums[i] + " and "+ nums[j]);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
