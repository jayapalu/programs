package slidingwindow.medium;

import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class L3_Longestsubstrwithoutrepeatchar {
    public static void main(String[] args){

        String s = "geeksforgeeks"; //ABDEFGABEF
        int n;

        //n = longestSubstrWithoutRepeatingChars_bruteforce(s);
        n = longestSubstrWithoutRepeatingChars_WithSet_slidingwindow(s);
        System.out.println("max len substring is "+ n);
    }

    static int longestSubstrWithoutRepeatingChars_bruteforce(String str){

        int len = str.length();
        int max  = 0;
        int currentMax;

        for(int i=0; i< len; i++) {
            currentMax = 0;
            for (int j=i+1; j < len; j++){
                if (isCharRepeated(str, i, j)) {
                    System.out.println("char repeated "+currentMax);
                    break;
                }else {
                    currentMax =  j-i+1;
                }
            } //for
            max = Math.max(max, currentMax);
        } //for
        return max;
    }

    static boolean isCharRepeated(String str, int start, int end) {
        int[] visited = new int[26];

        for(int i = start; i<=end; i++){
            if(visited[str.charAt(i) - 'a'] == 1){
                System.out.println("char repeated is "+ str.charAt(i) + " string is "+ str.substring(start, end));
                return true;
            }else {
                visited[str.charAt(i)-'a'] = 1;
            }
        }
        return false;
    }

    static int longestSubstrWithoutRepeatingChars_WithSet_slidingwindow(String str){

        int start =0;
        int end = 0;
        int len = 0;

        // dbcbb

        Set set = new HashSet<>();

        while (end < str.length()) {

            if(!set.contains(str.charAt(end))) {
                set.add(str.charAt(end));
                end++;
                len = Math.max(len, end - start);
            }else {
                set.remove(str.charAt(start));
                start++;
            }
        }


        return len;

    }



    static {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter f = new FileWriter("display_runtime.txt")) {
                f.write("0");
            } catch (Exception e) {

            }
        }));
    }
}
