import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class phoneLetterComb17 {

    public static void main(String[] args){
        String str = "";
        System.out.println(letterCombinations(str));


    }

    public static  List<String> letterCombinations(String digits) {

        List<String> resList = new ArrayList<>();
        if (digits.length() == 0){
            return  resList;
        }

        String[] letterPad = {"0","1","abc","def","ghi","jkl", "mno", "pqrs","tuv","wxyz"};
        Queue<String>  q = new LinkedList<>();

        q.add("");

        while(!q.isEmpty()){
            String s = q.remove();
            //System.out.println("Char removed from the queue = "+s);
            if(s.length() == digits.length()) {
                //System.out.println("      string added into res list = "+s);
                resList.add(s);
            }else {
                //read the number from the digits and get the string from digits pad

                String val = letterPad[digits.charAt(s.length()) - 48];
                //System.out.println("               digits val = "+val);

                // add the characters from the val into the queue

                for(int i=0; i<val.length(); i++){
                    q.add(s+val.charAt(i));
                }

            }
        } //while
        return resList;
    } //method

}
