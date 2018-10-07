package javaconcept;

import java.util.*;

public class Game {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        /* Test cases
        1
        18 4
        0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 1 1 1 //ans yes

        1
        9 4
        0 1 1 0 0 1 1 0 1 //ans yes

         */

        int i = 0;
        int len = game.length;

        if (canWinFwd(leap, game) || canWinLeap(leap, game) || canWinFwdOnly(leap, game)) {
            return true;
        }
        return false;
        }

        public static boolean canWinFwd(int leap, int[] game) {
            // Return true if you can win the game; otherwise, return false.

            int i = 0;
            int len = game.length;

            while (i < game.length) {
                // 1. check the i+1 is 0
                if (game[i + 1] == 0 &&  i+leap <= len-1 && game[i+leap] != 0) {

                    i = i + 1;
                    if (i >= len - 1) {
                        return true;
                    }
                } else {
                    if (i + leap >= len) {
                        return true;
                    }

                    if (leap > 0 && game[i + leap] == 0) {
                        i = i + leap;

                        if(i == len -1){
                            return true;
                        }
                        if (game[i + 1] != 0 && game[i - 1] == 0) {
                            i = i - 1;
                        } else {
                            continue;
                        }
                    } else {
                        return false; //case 0001110 and leap 3
                    }
                }
            }
            return false;
        }

    public static boolean canWinLeap(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        /* Test cases
        1
        18 4
        0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 1 1 1
         */

        int i = 0;
        int len = game.length;

        while (i < game.length) {
            // 1. check the i+1 is 0
            if (i + leap >= len) {
                return true;
            }

            if (i+leap < len-1 && game[i+leap] == 0 && leap >0) {

                //if (leap > 0 && game[i + leap] == 0) {
                    i = i + leap;
                    if(i == len -1){
                        return true;
                    }
                    if (game[i + 1] != 0 && game[i - 1] == 0) {
                        i = i - 1;
                }
            } else if (game[i+1] == 0) {
                i=i+1;
                if (i == len-1){
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public static  boolean canWinFwdOnly(int leap, int[] game) {

        int i = 0;
        int len = game.length;

        while (i < game.length) {
            // 1. check the i+1 is 0
            if (game[i + 1] == 0) {

                i = i + 1;
                if (i >= len - 1) {
                    return true;
                }
            } else {
                if (i + leap >= len) {
                    return true;
                }

                if (leap > 0 && game[i + leap] == 0) {
                    i = i + leap;

                    if(i == len -1){
                        return true;
                    }
                    if (game[i + 1] != 0 && game[i - 1] == 0) {
                        i = i - 1;
                    } else {
                        continue;
                    }
                } else {
                    return false; //case 0001110 and leap 3
                }
            }
        }
        return false;

    }
        public static void main (String[]args){
            Scanner scan = new Scanner(System.in);
            int q = scan.nextInt();
            if (q < 1 || q > 5000) {
                return;
            }
            while (q-- > 0) {
                int n = scan.nextInt();
                if (n < 2 || n > 100) {
                    return;
                }
                int leap = scan.nextInt();

                if (leap < 0 || leap > 100) {
                    return ;
                }

                int[] game = new int[n];
                for (int i = 0; i < n; i++) {
                    game[i] = scan.nextInt();
                }

                System.out.println((canWin(leap, game)) ? "YES" : "NO");
            }
            scan.close();
        }
    }

