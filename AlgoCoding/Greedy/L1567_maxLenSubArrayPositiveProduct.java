public class L1567_maxLenSubArrayPositiveProduct {

    public static void main(String[] args) {

    }

     static int findMaxSubArray(int[] a) {

        int firstIndex = -1;
        int seconIndex = -1;
        int start = 0;
        int maxLen;

        for(int i=0; i<a.length; i++) {

            if(a[i] == 0) {
                firstIndex = -1;
                seconIndex = -1;
                start = i+1;
                continue;
            }

            if(a[i] < 0) {
                if(firstIndex == -1) {
                    firstIndex = i;
                }else if(seconIndex == -1){
                    seconIndex = i;
                }else {
                    firstIndex = seconIndex;
                    seconIndex = i;
                }
            }



        }
        return 1;

    }
}
