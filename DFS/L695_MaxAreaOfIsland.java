public class L695_MaxAreaOfIsland {

    public static void main(String[] args){

        int [][] grid =  {{ 1,1,0,0},
                {1,1,0,0},
                {0,0,0,0},
                {1,1,1,1},
                {1,1,1,1}
        };

       int res =  findMaxAreaIsland(grid);
        System.out.println("res = "+ res);



    }

    private static int  findMaxAreaIsland(int[][] grid) {

        int numOfislands = 0;
        int maxArea = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                // Island only start with land or 1. check only for those.
                //Already visisted will be updated to 2. So those won't be checked.
                if(grid[i][j] == 1) {
                    numOfislands += 1;
                   maxArea = Math.max(maxArea, 1+callDFS(grid, i, j));
                   System.out.println("Max are = "+ maxArea);
                }
            }
        }

        return maxArea;

    }//method

    private static int callDFS(int[][] grid, int i, int j) {
        //check the boundry conditions, and matrix[i][j] == 0 or visited that is matrix[i][j] == 2;
        if( i < 0 || i > grid.length-1 || j < 0 || j > grid[0].length-1 || grid[i][j] == 0 || grid[i][j] == 2 ) {
            //simply return here. no return value.
            return -1;
        }

        //This cell is 1 so marked it as visited upfront and moving to next cells left, right, top, bottom
        // Here we are marking visited in the starting only.

        grid[i][j] = 2;

        int up = 1 + callDFS(grid, i-1, j); //up
        int down = 1+ callDFS(grid, i+1, j); //down
        int left = 1+ callDFS(grid, i, j-1); //left
        int right = 1+ callDFS(grid, i, j+1); //right

        return up + down + left + right;

    }

}
