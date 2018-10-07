package javaconcept;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    private static final Scanner scanner = new Scanner(System.in);
    static int subarray(int [][] arr, int r,int c){
        int sum=0;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                //System.out.printf("i=%d,j=%d,j",i,j);
                sum=sum+arr[i][j];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        int max=0;
        int sum=0;
        for (int i = 0; i < 6; i++) {
            //String[] arrRowItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            //System.out.println(Arrays.toString(arrRowItems));

            for (int j = 0; j < 6; j++) {
                //int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("The array elements are");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(" "+arr[i][j]);
            }
            System.out.println("");
        }

        //read 3x3 array ..
        //4 iteration
        for(int r=0;r<6-3; r=r+1){
            for(int c=0;c<6-3;c=c+1){
                sum=subarray(arr, r,c);
            }
        }
        if(sum>max){
            max=sum;
        }
        System.out.println(max);
    }
}
