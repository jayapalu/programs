import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Twonums2 {

    public static void main(String[] args) {

        int[] num = new int[] {1,2,3,4,5};
        if (twonums(num, 10) != -1){
            System.out.println("ele found");
        }
    }

    public static int twonums(int[] nums, int target) {

        HashSet<Integer> set = new HashSet<>();

        for (int i=0; i< nums.length; i++){

            if(set.contains(target - nums[i])) {
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
}
