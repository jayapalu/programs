import java.util.ArrayList;
import java.util.Arrays;

public class Dice {

    public static void main(String[] args) {
        dice("", 4);
        //ArrayList<String> list = diceRet("", 4);
        //System.out.println(list);
    }

    static void dice(String p, int target) {

        System.out.println(" p="+p +" target="+target);
        if(target == 0){
            System.out.println(p);
            return;
        }
       // for (StackTraceElement each: new Exception().getStackTrace()) System.out.println(each);

        for(int i = 1; i<=6 && i <= target; i++){
            System.out.println("  p="+p + " i="+i);
            System.out.println("  dice("+p+i+ ","+(target-i)+")");
            dice(p+i, target - i);
            //System.out.println(" after dice   i="+i+ " p="+p +" target="+target);
        }
        System.out.println("#### Method end ########p="+p +" target="+target);

    }//method


    static ArrayList<String> diceRet(String p, int target) {
        //System.out.println(" p="+p +" target="+target);
        ArrayList<String> list = new ArrayList<>();
        if(target == 0){
            //System.out.println(p);
            list.add(p);
            return list;
        }

        for(int i = 1; i<=6 && i <= target; i++){
            //System.out.println("    i="+i+ " p="+p +" target="+target);
            list.addAll(diceRet(p+i, target - i));
            //System.out.println(" after dice   i="+i+ " p="+p +" target="+target);
        }
        //System.out.println("#### Method end p="+p +" target="+target);
        return list;

    }//method
}
