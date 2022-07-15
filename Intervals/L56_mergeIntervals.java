import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class L56_mergeIntervals {

    public static void main(String[] args){

        int[][] intervals = new int[][] {{8,9}, {3,5}, {7,8}, {3,4}};

        merge(intervals);
        int[] ts;
        int [][] res = new int[3][];


    }

    public static int[][] merge(int[][] intervals){

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        //Arrays.sort(intervals, (a,b)->(Integer.compare(a[0], b[0])));

        //Arrays.sort(intervals, (a1[], a2[])-> (Integer.compare(a1[0], a2[0])))

        //System.out.println(Arrays.toString(intervals[0]));

        LinkedList<int[]> mergelist = new LinkedList<>();

        for(int[] interval : intervals) {

            //(a,b) (c,d)   if b < c then we can't merge
            if (mergelist.isEmpty() || mergelist.getLast()[1] < interval[0]) {
                mergelist.add(interval);
            }else {
                mergelist.getLast()[1] = Math.max(mergelist.getLast()[1], interval[1]);
            }
        } // for
        return mergelist.toArray(new int[mergelist.size()][]);
    }
}
