package medium;

import java.util.HashMap;
import java.util.Map;

public class L128_LongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }

        //Map<number, count>

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;

        for(int i=0; i<len; i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i], 1);
        }

        for(int i=len-1; i >= 0; i--){
            int next = 1;
            int count = 1;

            //look for next greater numbers
            while(map.containsKey(nums[i] + next)){
                count++;
                map.put(nums[i], count);
                next++;
            }

            if(count > max){
                max = count;
                //System.out.println("Max = "+ max);
            }
        } //for

        //System.out.println(map);
        return max;
    }
}
