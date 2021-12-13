import java.util.*;

public class Rarrangewords1451 {

    public static void main(String[] args){
        String text = "To be or not to be";
        splitAndSort(text);  // this solution deleting the duplicates
        arrangeWords(text);
        //listDuplicates();
    }

    public static void arrangeWords(String text) {
        String[] s = text.toLowerCase().split(" ");
        Arrays.sort(s, (a, b) -> a.length() - b.length());
        String ans = String.join(" ", s);
        System.out.println(Character.toUpperCase(ans.charAt(0)) + ans.substring(1));
    }

    public static String splitAndSort(String text) {

        Map<String, Integer> map = new LinkedHashMap<>();
        String[] strs = text.split(" ");
        for(String s : strs) {

            System.out.println(s);
            map.put(s, s.length());
        }

        System.out.println("Map entries are");

        for(String s: map.keySet()) {
            System.out.println(s);
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list,  (o1,o2) -> (o1.getValue().compareTo(o2.getValue())));

//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o1.getValue() - o2.getValue();
//            }
//        });

        int i=0;
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(Map.Entry<String, Integer> entry : list){
            if( j == 0){
                System.out.println(" " + entry.getKey().substring(0,1).toUpperCase()+entry.getKey().substring(1) + " " + entry.getValue());
                j++;
            }else {
                System.out.println(" " + entry.getKey().toLowerCase() + " " + entry.getValue());
            }
            //sb = sb.append(" ").append(entry.getKey());
        }
        //System.out.println(sb.toString());

        return "";
    }

    public static void listDuplicates() {
        String text = "To be or not to be";

        String[] strs = text.toLowerCase().split(" ");

        List<String> list = Arrays.asList(strs);
        list.sort((s1,s2)->s1.length() - s2.length());
        for(String s : list){
            System.out.println(s);
        }


    }
}
