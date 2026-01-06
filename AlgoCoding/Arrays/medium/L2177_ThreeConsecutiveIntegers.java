package medium;

public class L2177_ThreeConsecutiveIntegers {
    public static void main(String[] args) {

        int num = 33;

        sumOfThree(num);
    }

    static long[] sumOfThree(long num) {

        long[] res = new long[3];

        if(num % 3 != 0) {
            return new long[]{};
        }

        long val = num / 3;

        res[0] = val - 1;
        res[1] = val;
        res[2] = val + 1;

        return res;
    }
}
