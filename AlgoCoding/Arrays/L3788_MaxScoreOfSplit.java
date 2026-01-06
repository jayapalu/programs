import java.util.Arrays;


public class L3788_MaxScoreOfSplit {

    public static void main(String[] arg) {
        //int[] a = {10,-1,3,-4,-5};

         int[] a = {1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000};
        long res = maxScore3(a);
        System.out.println("######## max score of split " + res);
    }

    public static long maxScore(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        long maxScore = Long.MIN_VALUE;
        long leftSum = 0;

        // Precompute suffix minimums so we can get min from i+1..end in O(1)
        long[] suffixMinFrom = new long[len];
        suffixMinFrom[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            suffixMinFrom[i] = Math.min(suffixMinFrom[i + 1], (long) nums[i]);
        }

        for (int i = 0; i < len - 1; i++) {
            leftSum = leftSum + nums[i];
            System.out.println("array sum updated to " + leftSum + " i = " + i + " num[i] = " + nums[i]);

            long suffixMin = suffixMinFrom[i + 1];

            System.out.println("suffix min = " + suffixMin);
            maxScore = Math.max(maxScore, (leftSum - suffixMin));
            System.out.println("max score updated to " + maxScore);
        }
        return maxScore;
    }

    //optimized version without precomputing suffix mins, do it on the fly in the main loop.
    public static long maxScore2(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        long maxScore = Long.MIN_VALUE;
       // long prefixSum = 0; //Arrays.stream(nums).sum();
        long prefixSum = Arrays.stream(nums).mapToLong(n -> n).sum();

        System.out.println("leftsum = " + prefixSum);

        // Precompute suffix minimums so we can get min from i+1..end in O(1)
        long[] suffixMinFrom = new long[len];
        suffixMinFrom[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            suffixMinFrom[i] = Math.min(suffixMinFrom[i + 1], (long) nums[i]);
        }

        for (int i = len-2; i >= 0 ; i--) {
            prefixSum = prefixSum - nums[i+1];
            System.out.println("array sum updated to " + prefixSum + " i = " + i + " num[i] = " + nums[i]);

            long suffixMin = suffixMinFrom[i + 1];

            System.out.println("suffix min = " + suffixMin);
            maxScore = Math.max(maxScore, (prefixSum - suffixMin));
            System.out.println("max score updated to " + maxScore);
        }
        return maxScore;
    }


    public static long maxScore3(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        long maxScore = Long.MIN_VALUE;
        // long prefixSum = 0; //Arrays.stream(nums).sum();
        long prefixSum = Arrays.stream(nums).mapToLong(n -> n).sum();

        System.out.println("leftsum = " + prefixSum);

        long suffixMin = nums[len-1];


        for (int i = len-2; i >= 0 ; i--) {
            prefixSum = prefixSum - nums[i+1];
            System.out.println("array sum updated to " + prefixSum + " i = " + i + " num[i] = " + nums[i]);

            System.out.println("suffix min = " + suffixMin);
            maxScore = Math.max(maxScore, (prefixSum - suffixMin));
            suffixMin = Math.min(suffixMin, (long)nums[i]);
            System.out.println("max score updated to " + maxScore);
        }
        return maxScore;
    }



    static long findMinInSuffix(int[] nums, int start) {
        long min = Integer.MAX_VALUE;
        for(int i = start ; i < nums.length ; i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
