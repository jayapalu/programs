import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L91_decodeWays {

    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {

        String str = "212";
        char[] alpha = {
                '#', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
                'Q','R','S','T','U','V','W','X','Y','Z'
        };

        int res = 0;

        res = decode_count(str, 0);
        System.out.println("res = "+ res);

        res = decode_count_memoizaton(str, 0);
    }


    public static int decode_count(String str, int index) {

        //System.out.println(" index = "+index);
        if(index == str.length() ) {
            return 1;
        }

        // if the char at the index is 0
        if(str.charAt(index) == '0') {
            return 0;
        }

        if(index == str.length() - 1) {
            return 1;
        }

        int ans;

        //increment the index by 1
        System.out.println("1 "+str.substring(index, index+1));
        ans = decode_count(str, index+1);

        //index+2 will not go out of bound because the it is retunred when index == length - 1
        // so here index will be at str.length-2;
        if( Integer.parseInt(str.substring(index, index+2)) <= 26) {
            //increment the index by 2
            System.out.println("1 "+str.substring(index, index+2));
            ans = ans + decode_count(str, index+2);
            System.out.println("str 2 ans ="+ans);
        }

        //System.out.println("        final ans ="+ans);
        return ans;
    }



    public static int decode_count_memoizaton(String str, int index) {

        if(map.containsKey(index)) {
            return map.get(index);
        }

        System.out.println(" index = "+index);
        if(index == str.length() ) {
            return 1;
        }

        // if the char at the index is 0
        if(str.charAt(index) == 0) {
            return 0;
        }

        if(index == str.length() - 1) {
            return 1;
        }

        int ans;

        ans = decode_count_memoizaton(str, index+1);
        System.out.println(" 1 ans ="+ans);

        //index+2 will not go out of bound because the it is retunred when index == length - 1
        // so here index will be at str.length-2;
        if( Integer.parseInt(str.substring(index, index+2)) <= 26) {
            ans = ans + decode_count_memoizaton(str, index+2);
            System.out.println(" 2 ans ="+ans);
        }

        map.put(index, ans);

        System.out.println("        final ans ="+ans);
        return ans;
    }





    private static void decode(String str, List<String> result, char[] alpha) {

        System.out.println(" str = "+str);
        if(str.length() == 1 || str.isEmpty()){
            System.out.println("processed "+ result);

            System.out.println(" str == 1 returning");
            return;
        }

        List<String> processed = new ArrayList<>();
        processed.add(str.substring(0,1));
        System.out.println(" 1 str = "+ str);
        decode( str.substring(1), processed, alpha);

        System.out.println(" 2 str = "+ str);
        processed.add(str.substring(0,2));
        if(str.length() > 2) {
            decode(str.substring(2), processed, alpha);
        }else {
            decode("", processed, alpha);
        }

    }
}
