public class L487_maxConsecutiveOndesII {

    public static void main(String[] args) {

        int[] a = {0,0,0,0,0};
        int res = maxConsecutiveOnes(a);
        System.out.println(" res = "+ res);
    }

    /*
    An array with 0's and 1's. Find the max number of 1's with flipping one 0.
    It is like having  one zero in middle of 1s
    Use sliding window and always maintain only one 0 in widnow
     */



     static int maxConsecutiveOnes(int[] a) {
        int left = 0;
        int right = 0;
        int count = 0;
        int numOfzeros = 0;
        int allowedFlip = 1;

        while(right < a.length) {
            if(a[right] == 0) {
                numOfzeros++;
            }

            // if there are 2 zeros then move the left
            while(numOfzeros > allowedFlip) {
                if(a[left]  == 0) {
                    numOfzeros--;
                }
                left++;
            }

            count = Math.max(count, right-left+1);
            //System.out.println("count = "+count);

            right++;
        }//while

        return count;

    }
}
