// 14. Longest Common Prefix
public class ReverseInt {
    public static void main(String[] args) {
        int x = -21474;

        String[] strs = new String[]{"flower","flowar","flo"};

        //integer max: 2147483647   min: -2147483648
        //System.out.println("int max = "+ Integer.MAX_VALUE + " Int min="+Integer.MIN_VALUE);
        //System.out.println(reverse2(x));
        //reverse2(x);
        System.out.println("");
        System.out.println(longestCommonPrefix(strs));
    }

    public static int reverse(int x){
        long sum = 0;
        boolean flag = false;
        if(x < 0){
            flag = true;
            x = x*-1;
        }
        while(x > 0){ // L: this can be x != 0 so that posive and -ve can be handled

            int rem = x % 10;
            x = x/10;
            System.out.println("x/10 "+x + " rem="+rem);
            sum = (long)sum * 10 + rem;

            if(sum > Integer.MAX_VALUE){
                System.out.println("Integer exceeded");
                return 0;
            }
            System.out.println("sum= "+ sum );
        }
        return flag ?  (int) sum * -1 : (int) sum;
    }

    public static int reverse2(int x){

        int reverse = 0;

        while(x != 0){ // L: this can be x != 0 so that posive and -ve can be handled

            int rem = x % 10;
            x = x/10;
            System.out.println("x/2 "+x + " rem="+rem);
            reverse = reverse * 10 + rem;

            // detecting when the reversing is going out of range.
            if(reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE/10 && rem > 7)){
                System.out.println("Integer exceeded");
                return 0;
            }
            if(reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE/10 && rem < 8)) {
                return 0;
            }
            System.out.println("sum= "+ reverse );
        }
        return reverse;
    }

    public static String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.length; i++){
            System.out.println(strs[i]);
        }

        for(int i=0; i<strs[0].length(); i++){
            for(int j=0; j<strs.length ; j++ ) {
               // System.out.print("[i][j] "+ i +""+j);
                // i is column, so check each string for length
                if(i == strs[j].length()){
                    System.out.println("String length is over");
                    return sb.toString();
                }
                //j is row and i is column: column i is fixed and row j is changing.
                if (strs[j].charAt(i) != strs[0].charAt(i)){
                    return sb.toString();
                }
            }
            System.out.println("");
            sb.append(strs[0].charAt(i));


        }
        return sb.toString();
    }
}