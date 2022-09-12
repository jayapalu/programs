import java.util.HashSet;
import java.util.Set;

public class L139_WorkdBreak {
    public static void main(String[] args){

        String str = "catsanddog";
        String[] dict = {"cats","dog","sand","and","cat"};
        Set<String> set = new HashSet<>();

        for(String str1: dict){
            set.add(str1);
        }
        boolean res;
        res = wordbreak(str, set, 0);
        System.out.println("res = "+res);

        res = wordbreakMemoization(str, set, 0, new boolean[str.length()]);
        System.out.println(" wordbreakMemoization res = "+res);

    }

    public static boolean wordbreak(String str, Set<String> dict, int start) {
        if(start == str.length()) {
            System.out.println("Returning "+ start);
            return true;
        }

        System.out.println("####  start = "+ start);
        for(int end = start+1; end <= str.length(); end++){

            System.out.println("    for loop start = "+ start + " end= "+end +" substr="+str.substring(start, end));
            if (dict.contains(str.substring(start, end)) && wordbreak(str, dict, end)) {
                System.out.println("String found is "+ str.substring(start, end) +" ...after recursion call");
                return true;
            }
        } //for

        System.out.println(" >>>>     start = "+ start);
        return false;
    }


    public static boolean wordbreakMemoization(String str, Set<String> dict, int start, boolean[] memory) {

        System.out.println("####  start = "+ start);
        if(start == str.length()) {
            System.out.println("Returning "+ start);
            return true;
        }

        if(memory[start] != false){
            System.out.println(" Memoization returning start "+ start);
            return  memory[start];
        }
        for(int end = start+1; end <= str.length(); end++){

            System.out.println("    for loop start = "+ start + " end= "+end +" substr="+str.substring(start, end));
            if (dict.contains(str.substring(start, end)) && wordbreakMemoization(str, dict, end, memory)) {
                System.out.println("String found is "+ str.substring(start, end) +" calling recursion");
                memory[start] = true;
                return true;
            }
        } //for

        System.out.println(" >>>>     start = "+ start);
        return memory[start] = false;
    }

}
