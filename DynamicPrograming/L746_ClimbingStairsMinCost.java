import java.util.HashMap;
import java.util.Map;

public class L746_ClimbingStairsMinCost {

    // if we declare mem as class variable then the previous test case result will be in the map.
    // In leet code the class method is called multiple times so the will contains the previous test case results.
    // so move this method so before calling the recursion method fill it with the zeros.
    static Map<Integer,Integer> mem = new HashMap<>();
    public static void main(String[] args){

        /*
           [10,15,20]
           To reach end:
           start at 0:
                onestep:  10+15+20 ->end
                two step: 10+20->end
           start at 1 index:
            one step : 15 + 20 -> end
            two step: 15 -> end

            so the minimu is 15

         */
        int[] cost = {1,100,1,1,1,100,1,1,100,1};

        //{10,15,20};

        int res = 0;
        //res = findMinCost(cost);
        res = minCost_bottomup(cost);
        System.out.println("res = "+ res);
    }

    private static int findMinCost(int[] cost) {

        //PASSING length is important NOT len-1;
        return minCost_topdown(cost, cost.length);
    }

    private static int minCost_topdown(int[] cost, int index) {

        // here the number of stairs are minum 2
        System.out.println("index = " + index);
        if (index <= 1) {
            System.out.println("    returing from  = " + index);
            return 0;
        }


        if (mem.containsKey(index)) {
            return mem.get(index);
        }

        //THIS VERY VERY IMPORTANT
        int downOne_onestep_at_atime = cost[index - 1] + minCost_topdown(cost, index - 1);
        System.out.println("    onestep = " + downOne_onestep_at_atime);
        int downTwo_twostep_at_atime = cost[index - 2] + minCost_topdown(cost, index - 2);
        System.out.println("        twostep = " + downTwo_twostep_at_atime);

        mem.put(index, Math.min(downOne_onestep_at_atime, downTwo_twostep_at_atime));
        return mem.get(index);
    }


    private static int minCost_bottomup(int[] cost) {

        int[] dp = new int[cost.length+1];

        dp[0] = 0;
        dp[1] = cost[0];

        for(int index = 2 ; index < cost.length + 1; index++){

            int step1 = cost[index-1] + dp[index-1];
            int step2 = cost[index-2] + dp[index-2];

            System.out.println(" step1 "+step1 + " step2 = "+step2);
            dp[index] = Math.min(step1, step2);
            System.out.println("dp index  "+index +"    "+dp[index]);
        }
        return dp[cost.length];
    }


}


