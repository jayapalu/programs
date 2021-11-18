public class Atoi {

    public static void main(String[] args){

        String str = "-2147483649";

        atoi(str);
    }

    public static int atoi(String str){

        boolean positive = true;
        int num=0;
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            System.out.println(ch);
            if(ch == ' '){
                continue;
            }
            if(ch == '-'){
                System.out.println("Negative number");
                positive = false;
                continue;
            }else if (ch == '-'){
                System.out.println("Positive number");
                positive = true;
                continue;
            }

            if(ch >= 48 && ch <=57) {
                if(positive){
                    if(num * 10 ==  Integer.MAX_VALUE - 7 && ch - '0' > 7) {
                        System.out.println("Integer positive int overflow");
                        return num;
                    }
                }else {
                    if(num * 10 ==  Integer.MAX_VALUE - 7 && ch - '0' > 8) {
                        System.out.println("Negative  int overflow");
                        return num*-1;
                    }
                }
                num = num * 10 + ch - '0';
                System.out.println("char is digit "+ num);
            }else {
                System.out.println("char is not DIGIT");
                return num;
            }

        }


        return num;
    }

}
