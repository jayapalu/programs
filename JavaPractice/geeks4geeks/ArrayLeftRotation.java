
/* Program for array rotation
Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
https://www.geeksforgeeks.org/array-rotation/
*/

import java.util.Arrays;
import java.util.Scanner;

public class ArrayLeftRotation {

    public static void main(String[] args) {

        int[] a = new int[10];
        int r = 4;


        System.out.println("Enter array size");
        Scanner in = new Scanner(System.in);
        int i = 0;
        int n = in.nextInt();

        System.out.println("Enter array elements");
        while (n > 0 && in.hasNext()) {
            a[i++] = in.nextInt();
            n--;
        }
        int size=i;

        printArray(a, i);
        SearchInSortedRotatedArray ssr = new SearchInSortedRotatedArray();
        //method1(a,r);
        System.out.println("Array elements after roation");
        //leftRotation(a,r, size); //logic is wrong
        //rightRotation(a,r,size); // logic wrong

        rotationByReversal(a,r, size);

        printArray(a, i);
        int pivot = ssr.findPivot(a, size);
        System.out.println("Pivot index of the array and ele "+pivot+ " ele "+a[pivot]);

        System.out.println("Enter the element to search");
        int searchEle = in.nextInt();

        if(searchEle > a[pivot] && searchEle < a[size-1]){
            System.out.println("Ele found at at index= "+ Arrays.binarySearch(a, pivot, size-1, searchEle));
        } else {
            System.out.println("Ele found at at index= "+Arrays.binarySearch(a, 0,pivot, searchEle));
        }

    }

    static void method1(int[] a, int r) {
        int size=a.length;
        int i;
        int[] temp =new int[r];
        //take a temporary array to add r elements into it
        for (i=0; i<r ; i++){
            temp[i]=a[i];
        }
        printArray(temp, r);

        int j=0;
        for( i=r;i<size;i++){
            a[j++]=a[i];
        }
        printArray(a, size);

        j=0;
        for( i=size-r;i<size;i++){
            a[i]=temp[j++];
        }
        System.out.println("Array after rotation");
        printArray(a, size);
    }

    //left rotation inplace
    static void leftRotation(int[] a, int r, int size){



        int newIndex=0,i=0;
        int currentIndex=0;
        int newValue, backup;

        newValue = a[0];
        while(i<size){
            currentIndex = newIndex;
            // for current element get the new Index after rotation and place the current element in new index
            // for newIndex value repeat the smae process.
            newIndex = (size - (r%size) + currentIndex ) %size;
            backup = a[newIndex];
            a[newIndex] = newValue;


            newValue=backup;
            i++;
        }
    }

    // https://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/
    //right rotation inplace, here  (currentIndex + (r%size) + size ) %size;
    static void rightRotation(int[] a, int r, int size){

        int newIndex=0,i=0;
        int currentIndex=0;
        int newValue, backup;

        newValue = a[0];
        while(i<size){
            // for current element get the new Index after rotation and place the current element in new index
            // for newIndex value repeat the smae process.
            newIndex = (currentIndex + (r%size) + size ) %size;
            backup = a[newIndex];
            a[newIndex] = newValue;

            currentIndex = newIndex;
            newValue=backup;
            i++;
        }
    }

    // size=5 and r=2; a = [1,2,3,4,5]
    // revese [1,2] and [3,4,5] - review [2,1,5,4,3]
    // 1.Reverse the array from 0 to r-1 and r to size-1
    // 2. Reverse 0 to size-1
    static void rotationByReversal(int[] a, int r, int size){

        // here end index should be cafrelly given. [1,2,3,4,5,6]
        // if r=2 then end for swapping [1,2] should not be because 2 tries to swap 1 and 3 not 1 and 2
        reverse(a, 0, r-1);
        reverse(a, r, size-1);
        reverse(a, 0, size-1);
    }

    static void reverse(int[] a, int start, int end) {

        for (int i=start; i<end; i++){
            int temp=a[end];
            a[end]=a[i];
            a[i]=temp;
            end--;
        }
    }


    static void printArray(int a[], int n){

        System.out.println("Array elements are");
        for (int j = 0; j < n; j++) {
            System.out.print(a[j]+" ");
        }
        System.out.println();
    }
}

