import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class L1207_uniqueNumOfOccurances {

    public static void main(String[] args) {

        int[] a = {1,2,2,3,3,3};

        boolean res = findOccuranceUnique(a);
        System.out.println(" res = "+ res);

    }

    static boolean findOccuranceUnique(int[] a) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int ele : a) {

            map.put(ele, map.getOrDefault(ele, 0)+1);
           // System.out.println(" ele is "+ele + " count "+map.get(ele) );
        }

        Set<Integer> eleSet = map.keySet();
        for(int ele : eleSet) {

           // System.out.println(" ele and val "+ele + " count "+ map.get(ele));

            if(set.contains(map.get(ele))) {
                return false;
            }else{
                set.add(map.get(ele));
            }
        }

        return true;
    }
}
