package Searching;
/**
 * BinarySearch2
 */

// Find minimum absolute difference---->
public class BinarySearch2 {

    public static void binarySearch(int arr[], int target) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;  // Corrected mid calculation
            if (arr[mid] == target) {
                ans = mid;
                break;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // if element does not exist, find the minimum absolute difference
        int res = 0;
        if (ans == -1) {
            if (end == -1) {
                res = Math.abs(target - arr[start]);
            } else if (start == arr.length) {
                res = Math.abs(target - arr[end]);
            } else {
                int ans1 = Math.abs(target - arr[start]);
                int ans2 = Math.abs(target - arr[end]);
                res = Math.min(ans1, ans2);
            }
        }

        System.out.println(res);
    }

    public static int bitonicMinElement(int arr[]){
        int res = Math.min(arr[0], arr[arr.length-1]);
        return res;
    }

    public static int bitonicMaxElement(int arr[]){
        int i = 0;
        int j = arr.length-1;
        int res = 0;
        while(i <= j){
            int mid = (i+j)/2; 
    
            // Check if the mid element is the maximum
            if((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])){
                return arr[mid]; // Return the maximum element
            }
            else if(mid > 0 && arr[mid] > arr[mid - 1]){
                i = mid + 1;
            }
            else{
                j = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {2, 2, 4, 5, 7, 9, 25, 56, 88, 94};
        // binarySearch(arr, 25);  // Example target

        // increasing and decreasing array
        int barr[] = {2,5,7,11,22,99,10,2,1};
        int baarr[] = {22,1,0};
        // System.out.println(bitonicMinElement(barr));
        System.out.println(bitonicMaxElement(barr));
    }

}
