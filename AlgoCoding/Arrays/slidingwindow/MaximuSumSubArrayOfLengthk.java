public class MaximuSumSubArrayOfLengthk {

    //https://youtu.be/MK-NZ4hN7rs?t=1411
    // THis pattern with fixed lenght window
    public static void main(String[] args) {

        //the maximum sum sub array is {7,8,1} which is length 3 and sum 16
        int nums[] = new int[] {4,2,1,7,8,1,2,8,1,0};
        int k = 3;
        int result = maxSumSubArrayLenK(nums, k);
        System.out.println(result);
    }

    private static int maxSumSubArrayLenK(int[] nums, int k) {

        int currentRunningSum = 0;
        int maximuSum = Integer.MIN_VALUE;;

        for(int i = 0; i< nums.length; i++){
            System.out.println("i= "+i);

            // adding element to with window
            currentRunningSum += nums[i];

            // i starts with 0 , so k-1
            // size reached to widnow size
            if( i >= k-1){
                // find the max sum
                maximuSum = Math.max(currentRunningSum, maximuSum);
                System.out.println("current sum "+ currentRunningSum +" maxsum "+maximuSum);
                //delete the leftmost element from the widnow
                                                        // here i - (k-1) not i - k - 1
                currentRunningSum = currentRunningSum - nums[ i- (k -1) ];
            }

        }

        return maximuSum;
    }
}