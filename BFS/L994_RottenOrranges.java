import java.util.ArrayDeque;
import java.util.Queue;

public class L994_RottenOrranges {

    public static void main(String[] args) {
        int[][] grid =  {{2,1,1},{1,1,0},{0,1,1}};
        int res = orangesRotting(grid);
        System.out.println(" res = "+res);
    }

    static class pair {
        int row;
        int col;

        pair(int r, int c){
            this.row = r;
            this.col = c;
        }
        int getRow() {
            return row;
        }
        int getCol() {
            return col;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int timeElapsedInMin = -1;
        int freshOranges = 0;
        Queue<pair> queue = new ArrayDeque<>();

        int ROWS = grid.length;
        int COLS = grid[0].length;

        //Step1: get all the rotten oranges into the queue
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j< COLS; j++) {

                //add rotten organges indexs into queue
                if( grid[i][j] == 2) {
                    System.out.println(" Added index to queue "+i + "-"+j);
                    queue.offer(new pair(i,j));
                }else if( grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        System.out.println("Fresh orange= "+freshOranges);

        timeElapsedInMin++;
        System.out.println("Fresh orange= "+freshOranges + " time = "+timeElapsedInMin);

        //Step2 : add the end marker for first level
        //add the -1,-1 to the queue to indicate end of the traver
        queue.offer(new pair(-1,-1));

        //now do a BFS traversal on the queue to contaminate all the organges

        int[][] directions = {
                // add these indexes to move the current cell
                {-1,0}, //up
                {1, 0}, //down
                {0, -1}, //left
                {0, 1}   // right
        };

        //Step3 : DFS traversal on the queue
        while(!queue.isEmpty()){

            pair p = queue.poll();

            if(p.getRow() == -1) {
                //reached one level in the queue
                // For inner levels queue will not be empty.  so add end marker of the next level
                if(!queue.isEmpty()) {
                    queue.offer(new pair(-1,-1));
                    timeElapsedInMin++;
                }

                System.out.println(" time = "+timeElapsedInMin);
            }else {
                //Step 4: check the neighbours for contaimination

                for(int[] d : directions) {
                    int row = p.getRow() + d[0];
                    int col = p.getCol() + d[1];

                    if(row >= 0 && row < ROWS && col >=0 && col < COLS) {
                        if(grid[row][col] == 1) {
                            grid[row][col] = 2;
                            System.out.println(" Added index to queue "+row + "-"+col);
                            queue.offer(new pair(row, col));
                            freshOranges--;
                        }
                    }
                }

            }
        }

        return freshOranges == 0 ? timeElapsedInMin : -1;

    }
}






