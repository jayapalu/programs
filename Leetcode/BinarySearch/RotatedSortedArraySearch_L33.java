public class RotatedSortedArraySearch_L33 {

    public static void main(String[] args) {

        int[] nums = new int[] {1};

        //int pivot = findPivot(nums);
        int index = search(nums, 1);
        System.out.println(" ele indext "+ index);
    }

    static int search(int[] nums, int target) {
        int index = -1;
        int pivot = findPivot(nums);
        System.out.println("pivot ="+pivot);
        if (pivot == -1) {
            System.out.println("There is no roation so do normal binary search");
            index = binarySearch(nums, target, 0, nums.length - 1);
        } else {
            //search from start --> pivot and pivot+1 to end
            System.out.println("searching in first half");
            index = binarySearch(nums, target, 0, pivot);
            if (index == -1) {
                System.out.println("searching in second half");
                index = binarySearch(nums, target, pivot + 1, nums.length - 1);
            }
        }
        return index;
    }

    static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            System.out.println("start="+start + " end="+end + " mid="+mid);
            // 4,5,6,7,0.1.2
            //case 1
            if(mid < end && nums[mid] > nums[mid + 1]) {  //pivot found condition
                //mid exactly at the pivot, because array is sorted rotated
                //remember pivot is the max element
                return mid;
            //case 2:
            }else if(mid > start && nums[mid] < nums[mid - 1]) {
                //5,6,7,0,1,2,3  //mid= 3 ele = 0;
                return mid -1;
            //case 3:
            }else if (nums[mid] <= nums[start]) {
                System.out.println(" mid <= start condition");
                end = mid - 1;
            }else {
            //case 4:
                System.out.println(" mid > start");
                start = mid  + 1;
            }
        }//while

        return -1;
    } //method

    static int binarySearch(int[] nums, int target, int start, int end) {

        while(start <= end) {
            int mid = start + (end - start)/2;
            System.out.println("start= "+start +" end="+end +" mid="+mid);

            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
