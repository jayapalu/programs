public class FindDuplicateElement_L287 {

    public static void main(String[] args){

        int[] nums = new int[]{1,3,4,2,2};
        int result = findDuplicateNum(nums);
        System.out.println("duplicate num "+result);

    }

    public static int findDuplicateNum(int[] nums){

        int index = 0;
        while(index < nums.length) {

            // nums[i] == i+1 means element is in correct position
            if (nums[index] != index + 1) {
                int correct = nums[index] - 1;
                if (nums[index] != nums[correct]) {
                    //swap
                    swap(nums, index, correct);
                } else {
                    return nums[index];
                }
            } else {
                index++;
            }
        }

    return -1;
    }

    static void swap(int[] nums, int i, int j) {
       // System.out.println("Swapping indexes "+i +" and "+j +" and ele are "+ nums[i] + " and "+ nums[j]);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
