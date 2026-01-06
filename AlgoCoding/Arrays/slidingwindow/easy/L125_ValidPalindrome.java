package slidingwindow.easy;

public class L125_ValidPalindrome {

    public static void main(String[] args) {
        String str = "Madam, I'm Adam";
        boolean status = isPalindrome(str);
        System.out.println("is palindrome "+ status);
    }


    public static boolean isPalindrome(String s) {

        int len = s.length();
        int start = 0;
        int end = len -1;
        while (start<end) {

            if(!(s.charAt(start) >= 'a' && s.charAt(start) <= 'z' ||  s.charAt(start) >= 'A' && s.charAt(start) <= 'Z'
                    || s.charAt(start) >= '0' && s.charAt(start) <= '9')) {
                //System.out.println("start continue "+s.charAt(start));
                start++;
                continue;
            }

            if(!(s.charAt(end) >= 'a' && s.charAt(end) <= 'z' ||  s.charAt(end) >= 'A' && s.charAt(end) <= 'Z'
                    || s.charAt(end) >= '0' && s.charAt(end) <='9')){
                // System.out.println("end continue"+s.charAt(end));
                end--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(start))!= Character.toLowerCase(s.charAt(end))) {
                //System.out.println(" char is not equal"+s.charAt(start));
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}


