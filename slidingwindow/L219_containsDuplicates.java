import java.util.*;

public class L219_containsDuplicates {

    public static void main(String[] args) {

        int[] nums = new int[]{99,99};
        int k=2;
        boolean res;
        res = containsDuplicate(nums, k);
        System.out.println(" res = "+ res);

        res = containsDuplicate_treeset(nums,k);
        System.out.println(" treeset res = "+ res);

    }

    // It takes long time. All test cases passed but took long time
    //
    private static boolean containsDuplicate(int[] nums, int k) {

        int i=0;
        int j=0;
        int length = nums.length;

        if(k == 0){
            return false;
        }

        // abs(i-j) <= k and a[i] == a[j]
        for(i = 0; i<nums.length; i++) {

            //for j= Math.max(i-k, 0); j<i; j++
            for(j=i+1; (j<= i+k) && (j < length) ; j++){
                if(nums[i] == nums[j]){
                   // System.out.println("i="+i + " j="+j + " num="+nums[i]);
                    return true;
                }
            }

        } //for
        return false;
    }

    private static boolean containsDuplicate_updatedCondition(int[] nums, int k) {

        int i=0;
        int j=0;
        int length = nums.length;

        if(k == 0){
            return false;
        }

        // abs(i-j) <= k and a[i] == a[j]
        for(i = 0; i<nums.length; i++) {
            for (j= Math.max(i-k, 0); j<i; j++){
                if(nums[i] == nums[j]){
                    // System.out.println("i="+i + " j="+j + " num="+nums[i]);
                    return true;
                }
            }

        } //for
        return false;
    }


    private static boolean containsDuplicate_treeset(int[] nums, int k) {

        int i=0;
        int j=0;
        int length = nums.length;

        if(k == 0){
            return false;
        }

        //treeset searches in O(logN)
        Set<Integer> set = new TreeSet<>();

        for(i = 0; i<nums.length; i++) {

            if(set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            // set size
            if( set.size() > k){
                set.remove(nums[i-k]);
            }

        } //for
        return false;
    }

    private static boolean containsDuplicate_HashSet(int[] nums, int k) {

        int i=0;
        int j=0;
        int length = nums.length;

        if(k == 0){
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for(i = 0; i<nums.length; i++) {

            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);


            if( set.size() > k){
                set.remove(nums[i-k]);
            }

        } //for
        return false;
    }
}
