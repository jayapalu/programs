import java.util.ArrayList;
import java.util.List;

public class Strsubsequence {
    public static void main(String[] args) {
        String str = "abc";

        //strsubsets("", str);
        //strsubsets_1(str, "");
        //strsubsets_2("", str);
        List<String> result = new ArrayList<>();
        result = strsubsequence(str, "", result);
        System.out.println(result);
    }

    static void strsubsets(String processed, String unprocessed) {
        //proccessed is the result
        //unprocessed is the original string

        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        strsubsets(processed+ch, unprocessed.substring(1));
        strsubsets(processed, unprocessed.substring(1));
    }

    static void strsubsets_1(String str, String result) {
        if(str.isEmpty()){
            System.out.println(result);
            return;
        }
        char ch = str.charAt(0);
        //get the first char and add it to the result. remove the first character and send the string again
        strsubsets_1( str.substring(1),result+ch);
        //This call executed in return of the above so do not add anything to result but remove the first character and send the string again
        strsubsets_1( str.substring(1), result);
    }

    static void strsubsets_2(String result, String str) {
        if(str.isEmpty()){
            System.out.println(result);
            return;
        }
        char ch = str.charAt(0);
        //get the first char and add it to the result. remove the first character and send the string again
        strsubsets_2( result+ch, str.substring(1));
        //This call executed in return of the above so do not add anything to result but remove the first character and send the string again
        strsubsets_2( result, str.substring(1));
    }

    static List<String> strsubsequence(String str, String processingStr, List<String> result) {

        if(str.isEmpty()){
            result.add(processingStr);
            return result;
        }

        char ch = str.charAt(0);
        strsubsequence( str.substring(1), processingStr+ch, result);
        strsubsequence( str.substring(1), processingStr, result);
        return  result;
    }
}