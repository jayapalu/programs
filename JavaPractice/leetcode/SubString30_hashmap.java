import java.util.*;

public class SubString30_hashmap {

    public static void main(String[] args) {
        String str1 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words= {"fooo","barr","wing","ding","wing"};

        //System.out.println("Calling comparethestring");
        comparethestring(str1, words);
    }

    //"lingmindraboofooowingdingbarrwingmonkeypoundcake"
    //["fooo","barr","wing","ding","wing"]

    public static List<Integer> comparethestring(String str, String[] words){

        List<Integer> result =new ArrayList<>();
        int window = 0;
        int strlen = 0;
        int numOfwords = words.length;

        if(words.length != 0){
            String s1 = words[0];
            strlen = s1.length();
            window = s1.length() * words.length;
        }
        HashMap<String, Integer> wordMap = new HashMap<>();

        for (int j=0; j< words.length; j++) {
            String strItem = words[j];
            if(!wordMap.containsKey(strItem)) {
                wordMap.put(strItem, 1);
            }else {
                int val = wordMap.get(strItem);
                val++;
                wordMap.put(strItem, val);
            }
        }


        for (int i =0; i<= str.length() - window;  i=i+strlen) {

            String substr = str.substring(i, i+window);
            System.out.println("i = " + i + " substr = "+substr);

            boolean match = true;
            //list iterator
            HashMap<String, Integer> substrMap = new HashMap<>();
            for (int j=0; j< window ; j=j+strlen) {
                String substritem = substr.substring(j, j+strlen);
                System.out.println("substritem : " + substritem);

                if (!substrMap.containsKey(substritem)) {
                    substrMap.put(substritem, 1);
                } else {
                    int val = substrMap.get(substritem);
                    val++;
                    substrMap.put(substritem, val);
                }
            } //for

            for(Map.Entry<String, Integer> entry : wordMap.entrySet()) {

                String strkey = entry.getKey();
                Integer count = entry.getValue();
                System.out.println("wordmap key: "+ strkey + " val : "+count);

                if ( substrMap.get(strkey) != count ) {
                    System.out.println("Match not found for "+ strkey);
                    match = false;
                    break;
                }
            }

            if (match){
                result.add(i);
            }

        } //for

        System.out.println(result);
        return result;
    } //method
}
