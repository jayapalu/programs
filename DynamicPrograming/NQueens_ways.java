import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens_ways {

    public static void main (String[] args){

        int boardSize = 4;
        boolean[][] board = new boolean[boardSize][boardSize];
        for(boolean[] row : board) {
            Arrays.fill(row, false);
        }
        int count =  nqueens(board, 0);
        //System.out.println("Num of way to place queen = "+ count);

    }

    //passing only row is enough because column is same is row
    public static int nqueens(boolean[][] board, int row){

        // when row is moving out of board lenghth
        if(row == board.length ){
            printBoard(board, row);
            return 1;
        }

        int count = 0;
        // for each column on the bard try placing the queue
        for(int col=0; col < board.length; col++){
            if(isSafeToPlaceQueen(board, row, col)){
                board[row][col] = true;
                count = count + nqueens(board, row+1);
                board[row][col] = false;
            }
        }

        return  count;
    }

    public static boolean isSafeToPlaceQueen(boolean[][] board, int row, int col) {
       // System.out.println("isSafeToPlaceQueen called row="+row + " col="+col);
        int i = row -1;
        int leftDiagCol = col -1;
        int rightRigCol = col +1;

        while( i >= 0){
           // System.out.println("while row="+i + " leftcol="+leftDiagCol + " righcolumn"+rightRigCol);
            //condition to check the queen present or not in the previous cells
            // check abovre rows, left diagonal cells, right diagonal cells
            if( board[i][col]
                    || leftDiagCol >=0 && board[i][leftDiagCol]
                    || rightRigCol < board.length && board[i][rightRigCol]) {

               // System.out.println(" NOT SAFE row="+i + " col="+col);
                return false;
            }else {

                i--;
                leftDiagCol--;
                rightRigCol++;
            }
        } //while
       // System.out.println(" SAFE row="+i + " col="+col);
        return true;
    }

    private static void printBoard(boolean[][] board, int row) {

        List<String> result = new ArrayList<>();
        for(boolean[] rows : board) {
            List<String> list = new ArrayList<>();
            for(int i=0; i< rows.length; i++){
                if(rows[i]) {
                    list.add("Q");
                   // System.out.print(" Q ");
                }else{
                    //System.out.print(" X ");
                    list.add(".");
                }
            }
            result.addAll(list);
           // System.out.println("");

        }
        //System.out.println("-------------");
       // System.out.println(result);
    }
}
