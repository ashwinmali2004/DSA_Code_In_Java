package Arrays.Searching;

class ImportantQuestions {

    // BookAllocation Problem 
    // from max Element to the sum of the all element
    // than find the m as maximum allocation to student
    // than put the BinarySearch Algorithm
    public static int findPages(int[] arr, int k) {
        // code here
        if(arr.length<k){
            return -1;
        }
        
        int start = Integer.MIN_VALUE;
        int end = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>start){
                start=arr[i];
            }
            end = end + arr[i];
        }
        
        int res = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(isAllocation(arr, mid, k)){
                res = mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return res;
    }
    
    public static boolean isAllocation(int[] arr, int m, int k){
        int currentStudent = 1;
        int pages = 0;
        for(int i=0;i<arr.length;i++){
            pages += arr[i];
            if(pages>m){
                currentStudent++;
                pages = arr[i];
            }
            if(currentStudent>k){
                return false;
            }
        }
        return true;
    }

    // Similar problem 1011 Leetcode Exact Same!!!
    // 875 Similar KOKO Eating Bananas
    // 1283 Similar Smallest Divisor Given a Threshold
    // 2064 2064. Minimized Maximum of Products Distributed to Any Store
    
} 