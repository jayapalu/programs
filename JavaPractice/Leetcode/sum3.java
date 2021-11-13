import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/3sum/
//Input
//[-1,0,1,2,-1,-4,-2,-3,3,0,4]
//Output
//[[-2,-1,3],[-1,-1,2],[-1,0,1]]
//Expected
//[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
public class sum3 {

    public static void main(String[] args){

        int[] nums = new int[] {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        threeSum(nums);


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(nums.toString());
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        if(nums.length < 3) {
            return resList;
        }

        for(int i=0; i<nums.length - 3; i++) {
            int j = i+1;
            int k = nums.length - 1;
            int sum = 0;

            // tow pointer techinque
            while (j < k) {
                //binary search for the element between j and k
                //System.out.println(nums[i] + "  "+nums[j]+"  "+nums[k]);
               // sum = nums[j] + nums[k];
                //if(sum + nums[i] == 0){
                    res.clear();
                    //add the pair to list
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);

                    resList.add(res);
                    System.out.println(res);
                    //break;
                    j++; k--;
                }else {
                    int temp = (sum > nums[i]) ? k-- : j++;
                }
            }
        }

        return resList;
    }
}
