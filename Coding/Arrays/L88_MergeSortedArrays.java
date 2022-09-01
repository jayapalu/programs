import java.util.Arrays;

class L88_MergeSortedArrays {
    public static void main(String[] args){

        int[] num1 = new int[] {10,15,16,17,0,0};

        int[] num2 = new int[] {1,2};

        merge(num1, 4, num2, 2);
        System.out.println(Arrays.toString(num1));


    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int num1_rightIndex  = nums1.length - 1;

        int num2_lastEleIndex = n - 1;
        int num1_lastEleIndex = m-1;

        while(num2_lastEleIndex >=0 && num1_lastEleIndex >=0 ) {

            //System.out.println( "num1 ele "+ nums1[num1_lastEleIndex] + " num2 ele "+ nums2[num2_lastEleIndex]);
            //System.out.println( "num1 index "+ num1_lastEleIndex + " num2 index "+ num2_lastEleIndex +" right "+num1_rightIndex);
            if(nums1[num1_lastEleIndex] > nums2[num2_lastEleIndex]){
              //  System.out.println(" num1 ####");

                nums1[num1_rightIndex] = nums1[num1_lastEleIndex];
                num1_rightIndex--;
                num1_lastEleIndex--;
                System.out.println(Arrays.toString(nums1));
            }else {
               // System.out.println(" #### num2 ");
                nums1[num1_rightIndex] = nums2[num2_lastEleIndex];
                num1_rightIndex--;
                num2_lastEleIndex--;
                System.out.println(Arrays.toString(nums1));
            }
        }//

      //  System.out.println(" num1 last index"+ num1_lastEleIndex);
       // System.out.println(" num2 last index"+ num2_lastEleIndex);
        //left over elements
        while(num2_lastEleIndex >= 0){
            nums1[num1_rightIndex] = nums2[num2_lastEleIndex];
            num1_rightIndex--;
            num2_lastEleIndex--;
        }

        while(num1_lastEleIndex > 0){
            nums1[num1_rightIndex] = nums1[num1_lastEleIndex];
            num1_rightIndex--;
            num1_lastEleIndex--;

        }
    }


}