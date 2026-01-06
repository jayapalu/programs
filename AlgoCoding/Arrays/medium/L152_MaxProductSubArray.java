package medium;

public class L152_MaxProductSubArray {
    public static void main(String[] args) {

        int[] nums = {-5,1,0,2,3,-4,-2};
        int res = maxProduct(nums);
        System.out.println("res = "+res);
    }

     static int maxProduct(int[] nums) {
        int maxp = nums[0];
        int minp = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                //swap maxp and minp
                int temp = maxp;
                maxp = minp;
                minp = temp;
                System.out.println(" ==== -Ve num ====  maxp = "+ maxp + " minp = "+ minp + " num = "+ nums[i]);
            }

            maxp = Math.max(nums[i], maxp * nums[i]);
            minp = Math.min(nums[i], minp * nums[i]);

            System.out.println(" maxp = "+ maxp + " minp = "+ minp + " num = "+ nums[i]);
            result = Math.max(result, maxp);
        }

        return result;
    }

    static int maxProduct2(int[] num) {
        int maxProduct = num[0];
        int product = num[0];
        int negativeCount = 0;
        int lastNegativeIndex = -1;
        boolean oddNegativeFound = false;

        for (int i=0; i< num.length; i++) {
            if(num[i] < 0) {
                negativeCount++;
                lastNegativeIndex = i;
            }
        }

        if (negativeCount % 2 == 1) {
            oddNegativeFound = true;
        }
        System.out.println(" negativeCount = "+ negativeCount + " lastNegativeIndex = "+ lastNegativeIndex + " oddNegativeFound = "+ oddNegativeFound);

        for (int i=1; i< num.length; i++) {

            if (oddNegativeFound && num[i] < 0 && i == lastNegativeIndex) {
                //skip the last negative number
                System.out.println(" ### skipping last negative num = "+ num[i]);
                continue;
            }

            if (num[i] == 0) {
                product = 1;
                System.out.println(" ### num = 0 , reset product ");
                continue;
            }

            product = product * num[i];
            maxProduct = Math.max(maxProduct, product);
            System.out.println(" num = "+ num[i] + " product = "+ product + " maxProduct = "+ maxProduct);
        }

        return maxProduct;

    }
}
