public class Mountain_L852 {

    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 0};
        int result = peakIndexInMountainArray(nums);
        System.out.println("result index " + result + " value = " + nums[result]);
    }

    public static int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            // incrasing part of the array
            // there may be next higher element in the right.
            // so move the start to mid+1 because we know elements are incrasing after mid+1
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                // decreasing part of the array
                // *this may contains both increasing and decreasing
                // *we know that only last elemnt is in decreasing order

                // this is not going to be end = mid - 1
                // mid may be the ans so we need to check that as well.
                end = mid;
            }
        }
        // at the end start == end and pointing to largest element.
        //start and end are always find max element in while element.
        return start;
    }
}

