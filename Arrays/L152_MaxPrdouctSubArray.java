public class L152_MaxPrdouctSubArray {

    public static void main(String[] args) {

        int[] nums = {-5,0,-2,-3,-4};
        int res = maxProduct(nums);
        System.out.println("res = "+res);
    }

    // -5,0,-2,-3,-4
    // the test case to handled is
    // -1,-2,-3
    //-1,-2,-3,-4
    //[-2]
    //[0]
    //[3,-1,4]
     static int maxProduct(int[] nums) {
        int maxp = 0;
        int i=0;
        int cp = 1;
        int startIndex = 0;

        while(i < nums.length) {

            System.out.println(" i = "+i + " num = "+ nums[i]);
            if(nums[i] == 0){
                System.out.println(" nums[i] = 0 ");
                cp = 1;
                startIndex = i+1;
            }else {
                cp = cp * nums[i];
                System.out.println(" cp = "+cp);
                if(cp > maxp) {
                    maxp = cp;
                    System.out.println(" maxp updated = " + maxp);
                }else if(cp < 0 && startIndex < i) {
                    // current product is -ve, so need to delete the first element in subarray and check the product
                    if (cp/nums[startIndex] > maxp) {
                        maxp = cp/nums[startIndex];
                        System.out.println(" cp is -ve  updated = " + maxp);
                    }
                }
            }
            i++;
        }

        return maxp;

    }

}
