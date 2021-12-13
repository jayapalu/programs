public class BinarySearchInfiniteArray {

    public static void main(String[] args) {

        int nums[] = new int[] {1,3,4,5,6,7,8,9,10, 17,19,20,25,30,45,50,55,60};

        int result = binarySearchInfiniteArray(nums, 10);
        System.out.println("result ="+result);

    }

    static int binarySearchInfiniteArray(int[] nums, int target) {

        int start = 0;
        // start with two elements
        int end = 1;

        // break if the target is behind the end;
        // no need to check for the start < target and target < end
        while (target > nums[end]) {
            // as start is updating
            int newstart = end +1;
            end = end + (end - start + 1) * 2;
            //new start should be set to start
            start = newstart;
        }

        return binarySearch(nums, target, start, end);

    }
    static  int binarySearch(int[] nums, int target, int start, int end) {

        while(start<=end){

            int mid = start + (end - start)/2;

            if(nums[mid] == target) {
                return mid;
            }else if(target < nums[mid]){
                end = mid -1;
            }else {
                start = mid + 1;
            }

        }//while
        return -1;
    }
}
