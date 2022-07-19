import java.util.Arrays;

public class L395_longestSubstringAtleastKRepeatingChar {
    public static void main(String[] args) {

        String s = "aabbbc";
        int k = 2;

        longSubstrWithKrepeatingChar(s,k);

    }

    private static int longSubstrWithKrepeatingChar(String s, int k) {

        int maxLen = 0;
        int[] countMap = new int[26];
        for(int start = 0; start < s.length(); start++) {

            System.out.println(" char = "+s.charAt(start));

            Arrays.fill(countMap, 0);

            for(int end = start; end < s.length(); end++) {

                countMap[s.charAt(end)-'a']++;
                if(valid(s, start, end, k, countMap)) {
                    maxLen = Math.max(maxLen, end-start+1);
                    System.out.println(" updated maxlen = "+ maxLen);
                }
            }

        }
        return maxLen;
    }

    private static boolean valid(String s, int start, int end, int k, int[] countMap) {

        int countLetters= 0;
        int countAtleastK = 0;

        for(int freq : countMap) {

            // chart is present
            if(freq > 0) {
                countLetters++;
            }

            //char is present atleast k times
            if(freq >= k) {
                countAtleastK++;
            }

        }

        return  countLetters == countAtleastK;

    }
}
