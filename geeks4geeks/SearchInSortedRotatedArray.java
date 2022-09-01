public class SearchInSortedRotatedArray {

    int findPivot(int[] a, int size){
        System.out.println("Finding pivot ...");

        return findPivotCall(a, 0, size-1);
    }

    int findPivotCall(int[] a, int start, int end){

        if(start == end)
            return start;
        if(end < start)
            return -1;

        int mid = (start+end)/2;

        //{5,1,2,3,4}
        if (mid < end && a[mid] > a[mid + 1])
            return mid+1;

        if (mid > start && a[mid] < a[mid - 1])
            return (mid-1);

        if(a[mid] < a[mid-1] && a[mid] < a[mid+1]) {
            return mid;
        }

        //ex: 2 3 4 5 1 here mid index 2 (ele 4)
        if (a[start] >= a[mid] && a[mid] > a[mid-1] && a[mid]<a[mid+1]){
           return findPivotCall(a,start, mid-1);
        }else{
            return findPivotCall(a,mid+1, end);
        }
    }
}
