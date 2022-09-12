public class RoationCount {
    public static void main(String[] args) {

        int[] nums = new int[] {4,5,6,7,1,2,3};
        findRoationCount(nums);
    }

    static  int findRoationCount(int[] nums) {
        int pivot = findPivot(nums);
        if(pivot == -1) {
            // there is no roation
            System.out.println("THere is no rotatoin found");
            return 0;
        }else {
            System.out.println(" rotation count "+ (pivot+1));
            return pivot+1;
        }
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
}
