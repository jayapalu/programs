public class L134_gasStation {

    public static void main(String[] args){
        int[] gas = {1,2,3,4,5};

        int[] cost = {3,4,5,1,2};

        int result = -1;
        result = FindgasStation(gas, cost);
        System.out.println("REsult = "+ result);

    }


    static int FindgasStation(int[] gas, int[] cost) {

        int startIndex = -1;
        int totalCost = 0 ;
        int prevIndex;
        for(int i=0; i<gas.length; i++) {
            System.out.println("i= "+i + " cost= "+cost[i] + " gas= "+gas[i]);

            if(cost[i] > gas[i]){
                System.out.println(" Gas is less than the cost so continue");
                continue;
            }

            totalCost = gas[i];
            int j;
            boolean jbreak = false;

            for(j=(i+1)%gas.length;  j != i; j = (j+1)%gas.length) {
                System.out.println(" i = "+i +" j= "+j);
                 prevIndex = j -1;
                if (j == 0){
                    prevIndex = gas.length-1;
                }

                System.out.println("    "+totalCost +" - "+ cost[prevIndex] + " + "+ gas[j] + " = "+(totalCost - cost[prevIndex] + gas[j]));
                totalCost = totalCost - cost[prevIndex] + gas[j];

                if( totalCost < 0){
                    jbreak = true;
                    break;
                }
            }

            if(jbreak) {
                continue;
            }

            int tc;
            if (j == 0){
                tc = totalCost - cost[gas.length-1];
            }else{
                tc = totalCost - cost[j-1];
            }

            if(tc > 0){
                System.out.println("      "+totalCost +" - "+ cost[i] + "  = "+(totalCost - cost[i]));
                System.out.println("            total cost =  "+ (totalCost - cost[i]));
                return i;
            }
        }
        return -1;

    }
}
