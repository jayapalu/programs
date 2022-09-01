public class L322_Coinchange {

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args){

        int[] coins = {1,3};
        int amount = 4;

        int res = 0;
        //coinChangeCount(coins, amount);
        //res = coinChangeCount_dp(coins, amount);
        //System.out.println("res = "+res);

        res = coinChangeCount_dp_memoization(coins, amount, new int[amount+1]);
        System.out.println("memoization res = "+res);

    }

    private static int coinChangeCount_dp_memoization(int[] coins, int remainingAmount, int[] memCount) {

        if(remainingAmount == 0){
            return 0;
        }
        // if the remaining amount goes less than the 0
        if(remainingAmount < 0){
            return -1;
        }

        if(memCount[remainingAmount] != 0){
            //System.out.println(" rem amt foudn in mem "+ memCount[remainingAmount] );
            return  memCount[remainingAmount];
        }

        int count = 0;
        int min = Integer.MAX_VALUE;
        //check all the coins
        for(int i=0; i<coins.length; i++){

            System.out.println("Remaining amt "+ remainingAmount +" i = "+i);

            // getting the count
            count = coinChangeCount_dp_memoization(coins, remainingAmount - coins[i], memCount);

            System.out.println(" count "+ count +" i = "+i);
            if(count >= 0){
                // 1 + count because on success count recursive tree height
                min = Math.min(min, 1+count);
                memCount[remainingAmount] = min;
                //System.out.println("min =" + min);
            }
        }

        System.out.println("refore retrun min "+ min );
        memCount[remainingAmount] = min == Integer.MAX_VALUE ? -1 : min;

        return  min == Integer.MAX_VALUE ? -1 : min;
    }

    //without memoization
    private static int coinChangeCount_dp(int[] coins, int remainingAmount) {

        if(remainingAmount == 0){
            return 0;
        }
        // if the remaining amount goes less than the 0
        if(remainingAmount < 0){
            return -1;
        }

        int count = 0;
         int min = Integer.MAX_VALUE;
        //check all the coins
        for(int i=0; i<coins.length; i++){

            // getting the count
            count = coinChangeCount_dp(coins, remainingAmount - coins[i]);

            if(count >= 0){
                // 1 + count because on success count recursive tree height
                // once remaining amount zero the number of coins need to be counted till root.
                //So on getting count >=0 that is success so it will min(min, 1+count)
                min = Math.min(min, 1+count);
                System.out.println("min =" + min);
            }
        }

        return  min == Integer.MAX_VALUE ? -1 : min;

    }


    //total number ways with repeated use of coins
    private static int coinChangeCount(int[] coins, int amount) {


        System.out.println("amount = "+ amount);
        if(amount == 0){
            return 1;
        }

        if(amount < 0){
            return 0;
        }

        int count = 0;

        for(int i=0; i<coins.length; i++){
            System.out.println("        i = "+i + " amount="+amount + " count = "+count);
            count = count + coinChangeCount(coins, amount - coins[i]);
        }

        System.out.println(" before return count = "+count);
        return count;
    }
}
