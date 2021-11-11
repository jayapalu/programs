package javaconcept;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class SubArraySum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        ArrayList<Integer> al[];
        al =(ArrayList<Integer>[]) new ArrayList[5];

        if (size <1 || size > 100){
            return;
        }
        int [] a = new int[size];
        for (int i=0;i<size; i++){
            a[i]=scanner.nextInt();
            if (a[i]<-10000 || a[i] >10000){
                return;
            }
        }

        int sum=0;
        int count=0;
        for(int k=0;k<size;k++) {
            for (int i = k; i < size; i++) {
                sum = 0;
                for (int j = k; j <=i; j++) {
                    //System.out.print(a[j]+",");
                    sum=sum+a[j];
                }
                if(sum<0){
                    count++;
                }
                //System.out.println(" ");
            }
        }
        System.out.println(count);

    }
}
