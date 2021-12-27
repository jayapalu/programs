public class MaxAvgSubArray_L643 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        maxSumSubArrayLenK(nums, 4);

    }


    private static double maxSumSubArrayLenK(int[] nums, int k) {
        int currentRunningSum = 0;
        double maxAvg = Integer.MIN_VALUE;
        double currentRunningAvg = 0;

        for (int i = 0; i < nums.length; i++) {
            System.out.println("i= " + i);

            // adding element to with window
            currentRunningSum += nums[i];

            // i starts with 0 , so k-1
            // size reached to widnow size
            if (i >= k - 1) {
                // find the max sum

                currentRunningAvg = (double) (currentRunningSum)/k;
                maxAvg = Math.max(currentRunningAvg, maxAvg);

                System.out.println("currentRunningAvg  " + currentRunningAvg + " maxAvg " + maxAvg);
                //delete the leftmost element from the widnow
                // here i - (k-1) not i - k - 1
                currentRunningSum = currentRunningSum - nums[i - (k - 1)];
            }

        }

        return maxAvg;
    }
}


