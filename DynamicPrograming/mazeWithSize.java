import java.util.ArrayList;

public class mazeWithSize {

    public static void main(String[] args){

        //https://youtu.be/zg5v2rlV1tM?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=1127
        int size = 3 ;
        int ways = 0;
        ways =  mazeWaysCount(51, 9);
       System.out.println("number ways to reach destination =  "+ ways);
       int[][] mem = new int [52][10];
        ways = mazeWaysCountMemorization(51,9,mem );
        System.out.println("number ways to reach destination MEM =  "+ ways);
        ///maizeWithPath(size,size, "");
       // ArrayList<String> list = maizeWithPathRetList(size,size, "");
       // System.out.println(list);
    }

    static int mazeWaysCount(int row, int col){
        // row and col are starting with size
        if(row == 1 || col == 1){
            return 1;
        }
        int right = mazeWaysCount(row, col-1);
        int down = mazeWaysCount(row-1, col);
        return right + down;
    }

    static int mazeWaysCountMemorization(int row, int col, int[][] mem) {

        if(row == 1 || col == 1){
            mem[row][col] = 1;
            return 1;
        }
        if(mem[row][col] != 0){
           // System.out.println("Value there in mem row="+row +" col="+col +" returning mem[][] "+mem[row][col]);
            return mem[row][col];
        }

        int right = mazeWaysCountMemorization(row, col-1, mem);
        int down = mazeWaysCountMemorization(row-1, col, mem);

        mem[row][col] = right + down;
        //System.out.println("row ="+row + " col="+col +" mem="+ mem[row][col]);
        return right + down;
    }

    static void maizeWithPath(int row, int col, String processed) {

        if(row == 1 && col == 1){
            System.out.println(processed);
        }

        if(col > 1){
             maizeWithPath(row, col-1, processed+"R");
        }

        if(row > 1){
            maizeWithPath(row-1, col, processed+"D");
        }
        return;

    }

    static ArrayList<String> maizeWithPathRetList(int row, int col, String processed) {

        if(row == 1 && col == 1){
           // System.out.println(processed);
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(col > 1){
            list.addAll(maizeWithPathRetList(row, col-1, processed+"R"));
        }

        if(row > 1){
            list.addAll(maizeWithPathRetList(row-1, col, processed+"D"));
        }
        return list;

    }
}
