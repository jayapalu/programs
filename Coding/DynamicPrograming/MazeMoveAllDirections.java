import java.util.Arrays;

public class MazeMoveAllDirections {

    //from one cell rat can move any direction. So we need to find the path.
    public static void main(String[] args){
        boolean[][] maze = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
                };

        int[][] path = new int[maze.length][maze[0].length];

       // moveAnyDirector("", maze, 0,0);
        moveAnyDirectionPrintAllPaths("", maze, 0, 0, path, 1);

    }

    static void moveAnyDirector(String path, boolean[][]maze, int row, int col) {

        if(row == maze.length-1 && col == maze[0].length - 1 ){
            System.out.println(path);
            return;
        }

        if(!maze[row][col]) {
            return;
        }

        // considering this cell so marking it as true. We will reset it to False at the end of visiting in all
        //directions
        maze[row][col] = false;

        //right
        if(col < maze[0].length - 1){
            moveAnyDirector(path+"R", maze, row, col+1);
        }

        //Down
        if(row < maze.length - 1){
            moveAnyDirector(path+"D", maze, row+1, col);
        }

        //left
        if(col >  0){
            moveAnyDirector(path+"L", maze, row, col-1);
        }

        //Up
        if(row >  1){
            moveAnyDirector(path+"U", maze, row-1, col);
        }

        maze[row][col] = true;
        return;
    }


    //https://youtu.be/zg5v2rlV1tM?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=5122
    static void moveAnyDirectionPrintAllPaths(String processed, boolean[][]maze, int row, int col, int[][]path, int step) {

        if(row == maze.length-1 && col == maze[0].length - 1 ){
            //System.out.println(processed);

            path[row][col] = step;
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            return;
        }

        if(!maze[row][col]) {
            return;
        }

        // considering this cell so marking it as true. We will reset it to False at the end of visiting in all
        //directions
        maze[row][col] = false;
        path[row][col] = step;

        //right
        if(col < maze[0].length - 1){
            moveAnyDirectionPrintAllPaths(processed+"R", maze, row, col+1, path, step+1);
        }

        //Down
        if(row < maze.length - 1){
            moveAnyDirectionPrintAllPaths(processed+"D", maze, row+1, col, path, step+1);
        }

        //left
        if(col >  0){
            moveAnyDirectionPrintAllPaths(processed+"L", maze, row, col-1, path, step+1);
        }

        //Up
        if(row >  1){
            moveAnyDirectionPrintAllPaths(processed+"U", maze, row-1, col, path, step+1);
        }

        maze[row][col] = true;
        path[row][col] = 0;
        return;
    }
}
