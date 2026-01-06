package slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class L76_MinWindowSubstring {
    public static void main (String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
//
//        String s = "a";
//        String t = "a";


        String res = minWindow(s, t);
        System.out.println("res = " + res);
    }
    public static String minWindow(String s, String t) {


        int tStrLength = t.length();
        String resStr = "";

        if (s.length() < tStrLength) return "";
        if (s.equals(t)) return s;


        Map<Character, Integer> sFreqMap = new HashMap<>();
        Map<Character, Integer> tFreqMap = new HashMap<>();
        for (int i=0; i< tStrLength; i++) {
            char ch = t.charAt(i);
            tFreqMap.put(ch, tFreqMap.getOrDefault(ch, 0) + 1);
        }

        int start =0;
        int end = 0;

        int NEED_LEN = tFreqMap.size();
        int have = 0;
        int minLen = Integer.MAX_VALUE;

        while (end < s.length()) {
            char endChar = s.charAt(end);
            sFreqMap.put(endChar, sFreqMap.getOrDefault(endChar, 0) + 1);

            if (tFreqMap.containsKey(endChar) && sFreqMap.get(endChar).intValue() == tFreqMap.get(endChar).intValue()) {
                have++;
            }

            while (have == NEED_LEN && start <= end) {
                // update min window
                // try to contract the window from start
                char startChar = s.charAt(start);
                sFreqMap.put(startChar, sFreqMap.get(startChar) - 1);

               // System.out.println(" #### start = "+start + " end = "+end + " have = "+ have);
                if ( end - start +1 < minLen ) {
                    minLen = end - start +1;
                    resStr = s.substring(start, end+1);
                    System.out.println(resStr);
                }

                if (tFreqMap.containsKey(startChar) && sFreqMap.get(startChar).intValue() < tFreqMap.get(startChar).intValue()) {
                    have--;
                }

                start++;
            }
            end++;

        }


       //System.out.println(resStr);
        return resStr;
    }
}
