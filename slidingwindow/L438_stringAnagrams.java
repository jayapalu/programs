import java.util.*;

public class L438_stringAnagrams {

    public static void main(String[] args) {

        String  s = "abab";
        String p = "ab";

        List<Integer> res = findAnagrams(s, p);
        System.out.println(res);

    }

    static List<Integer> findAnagrams(String str, String pAnaStr) {

        int plen = pAnaStr.length();
        int slen = str.length();
        List<Integer> list = new ArrayList<>();
        if (plen > slen) {
            return list;
        }

        Map<Character,Integer> pmap = new HashMap<>();
        Map<Character,Integer> map = new HashMap<>();


        for(int i=0; i<plen; i++) {
            pmap.put(pAnaStr.charAt(i), pmap.getOrDefault(pAnaStr.charAt(i), 0)+1);
        }

        //add char for str till 0 to plen-1
        for(int i=0; i<plen-1; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }


        for(int i=0; i+plen-1 < slen ; i++) {
            // now window lenth chars there in map
            map.put(str.charAt(i+plen-1), map.getOrDefault(str.charAt(i+plen-1), 0)+1);
            //System.out.println(" i="+i + " end = "+ (i+plen-1) + " window "+map.toString());
            if(map.equals(pmap)) {
                //System.out.println("    Sets are equal "+i);
                list.add(i);
            }

            map.put(str.charAt(i), map.get(str.charAt(i))-1);
            if(map.get(str.charAt(i)) == 0) {
                map.remove(str.charAt(i));
            }

        }

        return list;
    }

}
