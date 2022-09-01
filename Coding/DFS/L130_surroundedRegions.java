import java.util.ArrayList;
import java.util.List;

// Solution is NOT coveres all test cases
public class L130_surroundedRegions {

    public static void main(String[] args){

        char[][] board = {
                {'O','O','O','O'},
                {'O','x','x','O'},
                {'O','x','x','O'},
                {'O','O','O','O'}
        };
        //[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
        surrounded(board);
    }

    private static void surrounded(char[][] board) {

        System.out.println(" ---- row="+board.length + " collen="+board[0].length);
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 'O'){
                    surrounded_dfs(board, i, j, visited);
                }
            } //for
        } //for

        List<List<Character>> res = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            List<Character> inner = new ArrayList<>();
            for(int j=0; j<board[0].length; j++){
                inner.add(board[i][j]);

            } //for

            res.add(inner);
        } //for

        System.out.println(res.toString());

    }

    private static boolean surrounded_dfs(char[][] board, int row, int col, boolean[][] visited) {

        System.out.println(" >>>>>> left ---- row="+row + " col="+col);
        if( (row < 0 || row > board.length-1) || (col < 0 || col > board[0].length -1 )) {
            System.out.println("    FALSE ");
            return false;
        }

        if(visited[row][col]){
            System.out.println("    Visisted true ");
            return  true;
        }

        if( board[row][col] == 'X') {
            System.out.println("    X false ");
            return false;
        }

        board[row][col] = 'X';
        visited[row][col] = true;

        //left
        System.out.println(" left ---- row="+row + " col="+col);
        boolean left = surrounded_dfs(board, row, col-1, visited);
        //right
        System.out.println(" right ---- row="+row + " col="+col);
        boolean right = surrounded_dfs(board, row, col+1, visited);

        //up
        System.out.println(" up ---- row="+row + " col="+col);
        boolean up = surrounded_dfs(board, row-1, col, visited);

        //down
        System.out.println(" down ---- row="+row + " col="+col);
        boolean down = surrounded_dfs(board, row+1, col, visited);


        visited[row][col] = false;
        if(!(left && right && up && down)){
            System.out.println("Resetting row="+row + " col="+col);
            board[row][col] = 'O';
        }

        return true;
    }
}
