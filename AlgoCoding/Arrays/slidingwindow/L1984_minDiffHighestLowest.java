import java.util.Arrays;

public class L1984_minDiffHighestLowest {

    public static void main(String[] args) {

        int[] a = {9,4,1,7};
        int min = mindDiffHighToLowest(a, 3);
        System.out.println(min);
    }

    static int mindDiffHighToLowest(int[] a, int k) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(a));

        for(int i=0; (i+k-1) < a.length; i++) {

            System.out.println("i = "+ i + " i+k-1 = "+ (i+k-1) + " a[i+k-1] = " + a[i+k-1] + " a[i] = "+ a[i]);

            int diff  = a[i+k-1] - a[i];
            min = Math.min(diff, min);
            System.out.println(" diff = "+diff + " min= "+ min);
        }
        return min;
    }


}
