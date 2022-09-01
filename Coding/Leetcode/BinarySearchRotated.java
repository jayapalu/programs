public class BinarySearchRotated {

    public static void main(String[] args){

        int[] num = {4,5,6,7,0,1,2,3};

        binarySearch(num,0,7,9);
    }

    public static int binarySearch(int[] a, int low, int high, int key) {
        while(low <= high) {
            int mid = (low + high) / 2;
            System.out.println("low = " + low + " high= " + high + " mid= " + mid);
            System.out.println("  vals: low = " + a[low] + " high= " + a[high] + " mid= " + a[mid]);

            if (a[mid] == key) {
                System.out.println("key found");
                return key;
            }

            if (key < a[mid] && a[low] <= key) {
                System.out.println(" key < mid");
                high = mid-1;
            }else {
                System.out.println(" key > mid");
                low = mid+1;
            }
        }

        System.out.println("key not found");
        return -1;

    } //method
}
