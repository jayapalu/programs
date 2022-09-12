import java.util.HashMap;
import java.util.Map;

public class L198_houseRobber {

    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 1};

        int res = 0;
        res = robHouse(houses);
        System.out.println(" res = " + res);
    }


    private static int robHouse(int[] houses) {

        Map<Integer, Integer> mem = new HashMap<>();
        return robHouse_topdown(houses, mem,houses.length-1);
    }

    public static int robHouse_bottomup(int[] houses) {

        int[] dp = new int[houses.length -1];

        dp[0] = houses[0];
        dp[2] = Math.max(dp[1], dp[0]+houses[2]);

        for(int i=3; i<houses.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+houses[i]);
        }

        return dp[houses.length-1];
    }

    private static int robHouse_topdown(int[] houses, Map<Integer, Integer> mem, int index) {

        // there only one house
        if(index == 0){
            return houses[0];
        }

        //there only two houses
        if(index == 1){
            // if there are two houses then the he can rob 0 or 1. The maximum will max of house0, house1
            return Math.max(houses[0], houses[1]);
        }

        //if it is not calculated then
        if(!mem.containsKey(index)) {
            mem.put(index, Math.max(robHouse_topdown(houses, mem, index-1), robHouse_topdown(houses, mem, index-2)+houses[index]));
        }

        return mem.get(index);
    }
}
