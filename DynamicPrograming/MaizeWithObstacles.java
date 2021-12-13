public class MaizeWithObstacles {
    //This is a maze problem. Moving the rat right or down.
    //If there any obstable then it can't move to that cell.
    public static void main(String[] args){
        //https://youtu.be/zg5v2rlV1tM?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=2304
        int a[] = new int[3];
        int a1[] = new int[]{1,2,3};
        boolean maze[][] = new boolean[][]{{true, false},
                {true, true}
                         };
        System.out.println("rowsize "+ maze.length +" col size= "+ maze[0].length);
        mazeWithObstacles("", maze, 0, 0);

    }

    //row and column are starting from the zero
    static void mazeWithObstacles(String p, boolean[][] maze, int row, int col) {

        if(row >= maze.length - 1 && col >= maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!maze[row][col]) {
            return ;
        }

        if(row < maze.length - 1) {
            mazeWithObstacles(p+"R", maze, row+1, col);
        }

        if(col < maze[0].length - 1){
            mazeWithObstacles(p+"D", maze, row, col+1);
        }
    }
}
