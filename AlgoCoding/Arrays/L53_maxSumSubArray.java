public class L53_maxSumSubArray {

    public static void main(String[] args) {

        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSumSubArrayValue(a);

        System.out.println("max = "+ max);
    }

    static int maxSumSubArrayValue(int[] a) {

        int max = a[0];
        int currentSum = a[0];

        //start with 2nd element
        for (int i=1; i< a.length ; i++) {

            //add the current element with current sum.
            //get the max of current element and current sum
            currentSum = Math.max(a[i], a[i] + currentSum );

            max = Math.max(max, currentSum);

        }
        return max;
    }
}
