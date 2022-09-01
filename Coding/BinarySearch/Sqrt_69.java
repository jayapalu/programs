public class Sqrt_69 {
    public static void main(String[] args){

        int num = 700;
        int result = sqrt(num);
        System.out.println("result = "+result);
    }

    public static int sqrt(int num){

        if(num <= 1) {
            return num;
        }
        if(num == 2){
            return 1;
        }

        int mid = 1;
        int start = 1;
        int end = num/2;

        while(start <= end) {
            mid = start + (end -start)/2;
            int product = mid * mid;

            if(product == num) {
                return mid;
            }else if(product < num) {
                start = mid + 1;
            }else {
                end = mid -1;
            }
        }
        return mid - 1;
    }
}
