package medium;

public class L238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {

        int[] a = {1,2,3,4};
        int[] res = productExceptSelf(a);

        System.out.print("res = ");
        for(int num : res){
            System.out.print(num + " ");
        }
    }


    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        int zeroIndex = 0;

        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
                continue;
            }
            product = product * nums[i];
        }


        if (zeroCount == 1) {
            output[zeroIndex] = product;
            return output;
        } else if (zeroCount > 1) {
            return output;
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = product / nums[i];
        }

        return output;
    }
}
