import java.util.HashMap;
import java.util.Map;

class L190Reversebits {

    public static void main(String[] args){
        int num = 1;
        int res = 0;
        res = reverse(num);
        System.out.println(res);
        res = reverse_bitwiseonly(num);
        System.out.println("bitwise result "+res);
        res = reverse_memoisation(num);

        System.out.println("reverse_memoisation result "+res);

    }

    private static int reverse_memoisation(int num) {

        byte[] b = new byte[4];
        for(int i=0; i<4; i++){
            b[i] = (byte) ((num >> 8*i) & 0x00ff);
            System.out.println(" byte = "+b[i]);
        }

        int result = 0;

        for(int i=0; i<4; i++){
            result = result | reverseByte(b[i]);
            if(i < 3){
                result = result << 8;
            }
        }
        return result;
    }

    private static int reverseByte(byte b) {
        Map<Byte, Integer> cache = new HashMap<>();
        if(cache.containsKey(b)){
            System.out.println(" byte ="+b +" rev = "+ cache.containsKey(b) +" already exist");
            return cache.get(b);
        }

        int rev = 0;
        for(int i=0; i<8; i++){
            rev = rev | ((b >> i) & 1);
            if(i<7) {
                rev = rev << 1;
            }
        }

        cache.put(b, rev);
        return rev;
    }

    static int reverse(int num){
        int power = 31;
        int rev = 0;
        while(num != 0){
            //move 1 bit the LSB bit to MSB (right side)
            rev =  rev | ((num & 1) << power);

            //left shift by one position to get the next bit at LSB/first position
            num = num >> 1;
            power = power - 1;
        }
        return rev;
    }

    static int reverse_movingResult(int num){
        int rev = 0;
        for(int i = 0; i<32; i++){
            rev = rev | ( (num >> i)&1);
            //for last digit do not more the rev
            if(i<31) {
                rev = rev << 1;
            }
        }
        return rev;
    }

    //constant time O(1)
    static int reverse_bitwiseonly(int num){
        int ret = num;
        //first 16 bits are swapped
        ret = ret >>16 | ret << 16;

        //Note: >>> is important
        // reverse the each octet
        ret = (ret & 0xff00ff00) >>> 8 | (ret & 0x00ff00ff) << 8;

        // 4 bit are swapped in each octet
        ret = (ret & 0xf0f0f0f0) >>> 4 | (ret & 0x0f0f0f0f) << 4;

        // two bits are reversed in the octects
        ret = (ret & 0xcccccccc) >>> 2 | (ret & 0x33333333) << 2;

        // 1 bit is swapped in each octet
        ret = (ret & 0xaaaaaaaa) >>> 1 | (ret & 0x55555555) << 1;

        return ret;
    }
}