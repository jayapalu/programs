public class L200_NumberOfIslands {

    public static void main(String[] args){

        char[][] grid =  {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        int res = countIslands(grid);
        System.out.println(" Num of island = "+ res);
    }

    private static int  countIslands(char[][] grid) {

        int numOfislands = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                // Island only start with land or 1. check only for those.
                //Already visisted will be updated to 2. So those won't be checked.
                if(grid[i][j] == '1') {
                    numOfislands += 1;
                    callDFS(grid, i, j);
                }
            }
        }

        return numOfislands;

    }//method

    private static void callDFS(char[][] grid, int i, int j) {
        //check the boundry conditions, and matrix[i][j] == 0 or visited that is matrix[i][j] == 2;
        if( i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1 || grid[i][j] == '0' || grid[i][j] == '2' ) {
            //simply return here. no return value.
            return;
        }

        //This cell is 1 so marked it as visited upfront and moving to next cells left, right, top, bottom
        // Here we are marking visited in the starting only.

        grid[i][j] = '2';

        callDFS(grid, i-1, j); //up
        callDFS(grid, i+1, j); //down
        callDFS(grid, i, j-1); //left
        callDFS(grid, i, j+1); //right
    }
}
