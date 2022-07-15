public class L718_maxLenRepeatedSubarray {

    public static void main(String[] args) {

        int[] a = {1,2,3,2,1};
        int[] b = {3,2,1,4,7};

        int count = maxLenthSubarryRepeatedInAnotherArray(a,b);
        System.out.println(" count = "+count);

    }

    static int maxLenthSubarryRepeatedInAnotherArray(int[] a, int[] b) {

        int mem[][] = new int[a.length+1][b.length+1];
        int length  = 0;

        // start from the last.
        for(int i= a.length-1; i>=0; i--) {
            for(int j=b.length-1; j>=0; j--){

               // System.out.println(" i="+i + " j="+j + " "+mem[i][j]);

                if(a[i] == b[j]) {
                    //System.out.println(" a[i] == b[j] "+ a[i] + " "+b[j]);
                    mem[i][j] = mem[i + 1][j + 1] + 1;
                    length = Math.max(length, mem[i][j]);
                }

            }
        }

//        for(int i=0; i<=a.length ; i++) {
//            for(int j=0; j<b.length; j++){
//                System.out.print(mem[i][j]+" ");
//            }
//            System.out.println();
//        }
        return length;
    }

}
