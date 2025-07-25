package Arrays.Searching;
/**
 * BinarySearch2
 */

// Find minimum absolute difference---->
public class BinarySearch2 {

    public static void main(String[] args) {
        int arr[] = {2,2,4,5,7,9,25,56,88,94};
        int arr1[] = {0,0,0,0,0,1,1,1,1,1};
        int arr2[] = {22,2,3,5,6,8,9,11,13,22};
        findMinimumAbsoluteDifference(arr,0);
        findElementInInfiniteSortedArray(arr,57);
        findFirstOneInaBinaryInfiniteSortedArray(arr1);
        // increasing and decreasing array
        int barr[] = {2,5,7,11,22,99,10,2,1};
        int baarr[] = {22,1,0};
        // System.out.println(bitonicMinElement(barr));
        System.out.println(bitonicMaxElement(barr));

    }

    // find index of peak element and do + 1
    static void findFirstOneInaBinaryInfiniteSortedArray(int arr[]){
        int range[] = findRangeInInfiniteArray(arr,1);
        int ans = binarySearchFirstOccurrence(arr,1,range[0],range[1]);
        if(ans == -1){
            System.out.println("Element does not exist");
        } else {
            System.out.println("Found element at index :" + ans);
        }
    }
    static void findElementInInfiniteSortedArray(int arr[], int target){
        int range[] = findRangeInInfiniteArray(arr,10);
        int ans = binarySearchInRange(arr,10, range[0],range[1]);
        if(ans == -1){
            System.out.println("Element does not exist");
        } else {
            System.out.println("Found element at index :" + ans);
        }
    }

    static int[] findRangeInInfiniteArray(int arr[], int target){
        int range[] = new int[2];

        int start = 0;
        int end = 1;

        while(arr[end]<target){
            start = end;
            end = 2*end;
        }
        range[0] = start;
        range[1] = end;

        return range;
    }

    static void findMinimumAbsoluteDifference(int arr[], int target){

        if(arr.length == 0){
            return;
        }

        int ans = -1;
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                ans = mid;
                break;
            } else if(arr[mid]<target){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        // if element exists then ans will be zero
        int res = 0;

        // element does not exists
        if(ans == -1){
            if(end == -1){
                res = Math.abs(target - arr[start]);
            } else if(start == arr.length){
                res = Math.abs(target - arr[end]);
            }
            else {
                int ans1 = Math.abs(target - arr[start]);
                int ans2 =  Math.abs(target - arr[end]);
                res = (ans1<ans2)?ans1:ans2;
            }
        }
        System.out.println("Minimum Absolute difference is :"+ res);
    }

    static int binarySearchInRange(int arr[], int target, int start, int end){
        int ans = -1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                ans = mid;
                break;
            } else if(arr[mid]<target){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return ans;
    }
    static int binarySearchFirstOccurrence(int arr[], int target,int start, int end){
        int ans = -1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                ans = mid;
                end = mid-1;
            } else if(arr[mid]<target){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return ans;
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
}
