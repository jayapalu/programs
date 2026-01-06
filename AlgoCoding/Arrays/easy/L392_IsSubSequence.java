package easy;

import java.util.HashMap;
import java.util.Map;

public class L392_IsSubSequence {
    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";

        boolean res = isSubsequence(s, t);
        System.out.println(" res = "+ res);

    }

    static boolean isSubsequence(String s, String t) {

        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == s.length();
    }

    int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        // memoization to avoid re-computation for the large input with repeated words
        Map<String, Boolean> memory = new HashMap<>();
        for (String word : words) {
            if (memory.containsKey(word)) {
                if (memory.get(word)) {
                    count++;
                }
                continue;
            }

            if (isSubsequence(word, s)) {
                memory.put(word, true);
                count++;
            }else {
                memory.put(word, false);
            }
        }
        return count;
    }

    int numMatchingSubseq_optimized(String s, String[] words) {
        int count = 0;
        // memoization to avoid re-computation for the large input with repeated words
        Map<String, Boolean> workMap = new HashMap<>();
        for (String word : words) {
            if (workMap.containsKey(word)) {
                count+= workMap.get(word) ? 1 : 0;
            } else {

                boolean found = isSubsequence(word, s);
                workMap.put(word, found);

                if (found)
                    count++;
            }
        }
        return count;
    }
}

