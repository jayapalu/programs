public class L70_climbingstairs {
    public static void main(String[] args){
        int top=4;
        int maxSteps = 2;
        int numOfWays = 0;
//
//        numOfWays = climbing(top, 0, 2);
        System.out.println("Num of ways to reach "+ top +" is "+numOfWays);

        int[] result = new int[top];
        numOfWays = climbingWithMemoisation(top, 0, maxSteps, result);
        System.out.println("Num of ways to reach "+ top +" is "+numOfWays);
    }

    private static int climbing(int top, int stepReached, int maxStep) {

        if( stepReached == top ){
            //System.out.println("top reached returning 1");
            return 1;
        }
        if(stepReached > top){
           // System.out.println(" Max steps out of top ###");
            return 0;
        }

        int count = 0;
        for(int i = 1; i<= maxStep; i++ ){
            System.out.println(" i="+i + " count="+count);
            count = count + climbing(top, stepReached + i, maxStep);
        }
        System.out.println("return count ###"+ count +" stepsReached "+ stepReached);
        return  count;
    }

    //number currentStair from 1. stepReached is what is my current s
    private static int climbingWithMemoisation(int top, int stepReached, int maxStep, int[] result) {

        //System.out.println(" >>> steps reached "+ stepReached);
        if (stepReached < top && result[stepReached] != 0){
            return result[stepReached];
        }
        if( stepReached == top ){
            //System.out.println("top reached returning 1");
            return 1;
        }
        if(stepReached > top){
             //System.out.println(" Max steps out of top ###");
            return 0;
        }

        int count = 0;
        for(int i = 1; i<= maxStep; i++ ){
            //System.out.println(" i="+i + " Step reached="+stepReached +" count="+count);
            count = count + climbingWithMemoisation(top, stepReached + i, maxStep, result);
            //storing the number of ways to reach from current stair.
            //System.out.println("    i="+i + " stair reached "+stepReached +" count="+count);
        }
        //System.out.println("### return count "+ count+ " Steps reached ="+stepReached);
        result[stepReached] = count;
        return  count;
    }
}
