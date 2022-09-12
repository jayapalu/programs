import java.util.Arrays;

public class L1838_FreqofFrequentEle {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,4};
        int k = 5;

        int res = raiseTheFreqOfEle(arr, k);
    }

    private static int raiseTheFreqOfEle(int[] arr, int k) {

        int left = 0;
        int right = 0;
        long total = 0;
        int res = 0;

        Arrays.sort(arr);

        //sort the array. from left to right add the increase the ele with (less than or equal k)  and check if the window
        //elements are equal
        while( right < arr.length) {

            total += arr[right];
            System.out.println("right = "+right + " arr[right] = "+arr[right] +" total = "+total +" window val = " + arr[right] * (right-left+1));

            // when the widown size * right element is greater than total+k, then shrink the window
            while( arr[right] * (right-left+1) > (total + k) ) {
                total -= arr[left];
                System.out.println("        arr[left] = "+ arr[left] + " total="+ total );
                left++;
            }

            res = Math.max(res, (right - left +1));
            System.out.println("res = "+ res);
            System.out.println();
            right++;
        }

        return res;
    }
}
