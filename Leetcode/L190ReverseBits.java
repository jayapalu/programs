

class L190ReverseBits {

    public static void main(String[] args){

        String str = "111101110";
        reverseBits(str);
    }

    static void reverseBits(String str) {

        String res = reverse(str.toCharArray(), 0, str.length()-1);
        System.out.println(res);
        convertTodecimal(res);
    }

    private static void convertTodecimal(String res) {

        for(int i = res.length()-1; i>=0 ; i--){

        }
    }

    static String reverse(char[] str, int start, int end){

        if(start == end ){
            System.out.println(String.valueOf(str));
            return String.valueOf(str);
        }

        System.out.println(" start="+start+" end="+end+" char="+str[start]);
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;

        return reverse(str, start+1, end-1);
    }
}