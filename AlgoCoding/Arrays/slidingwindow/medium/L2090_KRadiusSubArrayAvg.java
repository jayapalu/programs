package slidingwindow.medium;

import java.util.Arrays;

public class L2090_KRadiusSubArrayAvg {
    public static void main(String [] args) {
        int[] arr = {7,4,3,9,1,8,5,2,6};
        int k = 3;

        int[] res = getAverages(arr, k);

        System.out.print("res = ");
        for(int num : res){
            System.out.print(num + " ");
        }

    }

    public static int[] getAverages(int[] arr, int k) {

        int len = arr.length;
        int[] res = new int[len];

        if (len == 1 && k == 0) {
            res[0] = arr[0];
            return res;
        }

        if (k >= arr.length) {
            Arrays.fill(res, -1);
            return res;
        }

        long sum = 0;
        for (int i = 0; i < len; i++) {


            if (i - k < 0 || i + k >= len) {
                res[i] = -1;
                sum = sum + arr[i];
                continue;
            }

            if ((i - k) >= 0 && (i + k) < len) {
                // first valid subarray
                if (i == k) {

                    for (int j =  k; j <= i + k; j++) {
                        sum = sum + arr[j];
                    }
                    res[i] = (int) (sum / (2 * k + 1));
                } else {
                    // sliding the window
                    sum = sum - arr[i - k - 1];
                    sum = sum + arr[i + k];
                    res[i] = (int) (sum / (2 * k + 1));
                    System.out.println(" i = "+i+" sum = "+sum+" res[i] = "+res[i]);
                }
            }
        }

        return res;
    }
}
