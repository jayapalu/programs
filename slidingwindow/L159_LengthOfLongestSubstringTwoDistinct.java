import java.util.HashMap;
import java.util.Map;

public class L159_LengthOfLongestSubstringTwoDistinct {


    public static void main(String[] args) {

        String str = "abcdefgh";

        int result = longestSubstr(str, 2);
        System.out.println("Result = "+result);
    }

    private static int longestSubstr(String str, int k) {

        int left = 0;
        int right = 0;
        int length=0;

        Map<Character, Integer> map = new HashMap<>();

        for(right =0; right <str.length(); right++) {

            Character ch = str.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);

           // System.out.println("Char ="+ch + " right="+right);

            while(map.size() > k) {

                int count = map.get(str.charAt(left));
               // System.out.println("    map size ="+map.size() + " left="+left + " left chart="+str.charAt(left) + " count="+count );
                if(count == 1) {
                    map.remove(str.charAt(left));
                }else {
                    map.put(str.charAt(left), map.get(str.charAt(left))-1);
                }
                left++;
            }

            length = Math.max(length, right-left+1);
          //  System.out.println("max len ="+length);
        }

        return length;
    }
}
