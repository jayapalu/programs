public class L79_wordSearch {

    public static void main(String[] args) {
        String word = "ASDEF";

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        wordSearchCall(board, word);
    }


    public static boolean wordSearchCall(char[][] word, String str) {


        int row = word.length;
        int col = word[0].length;

        boolean visited[][] = new boolean[row][col];

        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < word[0].length; j++) {
                if (wordsearch(word, str, i, j, 0, visited)) {
                    System.out.println("Word found stop search");
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean wordsearch(char[][] word, String str, int row, int col, int index, boolean[][] visited) {

        System.out.println(" row="+row + " col="+col);
        if(row > word.length-1 || col > word[0].length-1 || row < 0 || col <0) {
            System.out.println("    Index out of bounds : returning false ");
            return false;
        }

        if(visited[row][col]){
            System.out.println("    Visisted ... row="+row + " col="+col);
            return false;
        }

        if (index == str.length()-1  && str.charAt(index) == word[row][col]){
            System.out.println("    string found returning ");
            return true;
        }

        boolean up = false;
        boolean down = false;
        boolean right = false;
        boolean left = false;


        if(word[row][col] == str.charAt(index)) {
            visited[row][col] = true;
            System.out.println("    char matched "+ word[row][col]);
            down = wordsearch(word, str, row+1, col, index+1, visited);
            right = wordsearch(word, str, row, col+1, index+1, visited);
            up = wordsearch(word, str, row-1, col, index+1, visited);
            left = wordsearch(word, str, row, col-1, index+1, visited);
            visited[row][col] = false;
        }else{
            System.out.println("    else char not matched");
        }

        System.out.println(" Final return "+ (down || right || up || left));
        return down || right || up || left;
    }
}
