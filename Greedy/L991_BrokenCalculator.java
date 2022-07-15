public class L991_BrokenCalculator {

    public static void main(String[] args) {
        int result = brokenCalc(3, 15);
        System.out.println("result = "+result);

       result =  brokenCalcIterative(3,15);
        System.out.println("Iterative result = "+result);
    }

    private static int brokenCalcIterative(int x, int y) {

        int result = 0;

        while( y > x ) {
            result++;

            if(y%2 == 0) {
                y/=2;
            }else {
                y++;
            }
        }

        //observe the return. y will become less than x. So add result + (x-y) becuawse incrementing y by 1 for
        //x-y times.
        return result + (x-y);
    }

    static int brokenCalc(int startValue, int target) {

        // start from the target value do in reverse
        if (startValue > target) {
            return startValue - target;
        }

        // if start and target are equal return 0
        if (startValue == target) {
            return 0;
        }

        if (target % 2 == 0) {
            //here half the target instead of multiplying startValue
            return 1 + brokenCalc(startValue, target / 2);
        }

        //here increment the target instead of -1 of startValue
        return 1 + brokenCalc(startValue, target + 1);

    }


}