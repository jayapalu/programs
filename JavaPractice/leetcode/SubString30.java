import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubString30 {

    public static void main(String[] args) {
        String str1 = "wordgoodwordgoodbestword";
        String[] words= {"word", "good", "best","word"};

        System.out.println("Calling comparethestring");
        comparethestring(str1, words);
    }

    public static List<Integer> comparethestring(String str, String[] words){

        List<Integer> result =new ArrayList<>();
        int window = 0;
        int strlen = 0;
        if(words.length != 0){
            String s1 = words[0];
            strlen = s1.length();
            window = s1.length() * words.length;
        }

        for (int i =0; i< str.length() - window;  i=i+strlen) {

            String substr = str.substring(i, i+window);
            System.out.println("i = " + i + " sbustr = "+substr);

            boolean match = true;
            //list iterator
            for (int j=0; j< words.length; j++){
                String listStrItem = words[j];
                System.out.println("matching word "+listStrItem);
                if(!substr.contains(listStrItem)){
                    match = false;
                    System.out.println(" not matched "+listStrItem);
                    break;
                }
            }

            if(match) {
                System.out.println("offset = "+i);
                result.add(i);
            }
        }

    return result;
    } //method
}
