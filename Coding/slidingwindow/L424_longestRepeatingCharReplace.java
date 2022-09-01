import java.util.HashMap;
import java.util.Map;

public class L424_longestRepeatingCharReplace {

    public static void main(String[] args){

        String str = "AABABBA";
        int k = 1;

            int left=0;
            int maxLen = 0;
            int charMaxLen = 0;

            Map<Character, Integer> map = new HashMap<>();

            for(int right = 0; right < str.length(); right++) {

                Character ch = str.charAt(right);
                map.put(ch, map.getOrDefault(ch,0)+1);
                int len = map.get(ch);
                charMaxLen = Math.max(len, charMaxLen);
                System.out.println(" Char = "+ch + "   right = "+right + " charMaxlen ="+charMaxLen);

                //substring - charMaxLen
                while( (right-left)+1 - charMaxLen > k) {

                    System.out.println("    k");
                    map.put(str.charAt(left), map.get(str.charAt(left))-1);
                    left++;
                }
                maxLen = Math.max(maxLen, right-left+1);
                System.out.println(" maxLen = "+maxLen +" left = "+left);
            }

    }
}
