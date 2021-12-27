public class SmallestSubArrayWithGivenSum {
    //this sloiding window problem widnow size is not fixed.
    //Widow size is dynamic

    public static void main(String[] args) {

        int nums[] = new int[]{1,1,1};
        int targetSum = 4;

        int result = findSmallestSubArray(nums, targetSum);
        System.out.println("result = "+result);
    }

    private static int findSmallestSubArray(int[] nums, int targetSum) {

        int windowstart = 0;
        int minWinSize = Integer.MAX_VALUE;
        int currentRunningSum = 0;

        for(int windowend = 0; windowend < nums.length; windowend++){

            //adding num into window from right side
            currentRunningSum += nums[windowend];

            System.out.println("windowend =" + windowend);
            //check the condition and shrink the window from the left
            while(currentRunningSum >= targetSum){
                //calcuate the subarray length
                minWinSize = Math.min(minWinSize, windowend - windowstart + 1);
                System.out.println("currentRunningSum "+currentRunningSum +" subarraysize =" + minWinSize);
                currentRunningSum  = currentRunningSum - nums[windowstart];
                windowstart++;
            }
            System.out.println("    windowstart =" + windowstart);
        }
        return minWinSize != Integer.MAX_VALUE ? minWinSize: 0;
    }

}
