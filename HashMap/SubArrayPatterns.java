package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SubArrayPatterns {
    public boolean kSumSubarrayIsPresent(int[] arr, int k){
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        int sum = 0;
        for(int a : arr){
            sum += a;
            int rem = sum-k;
            if(set.contains(rem)){
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    public ArrayList<Integer> indexOfSubset(int[] arr, int k){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum =0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            int rem = sum-k;
            if(map.containsKey(rem)){
                int startIndex = map.get(rem)+1;
                list.set(0,startIndex);
                list.add(i);
                break;
            }
            map.put(sum, i);
        }

        return list;

        // BruteForce Approch-->
        // ArrayList<Integer> list = new ArrayList<>();
        // for(int i=0;i<arr.length;i++){
        //     int sum = 0;
        //     for(int j=i;j<arr.length;j++){
        //         sum += arr[j];
        //         if(sum==k){
        //             list.add(i);
        //             list.add(j);
        //             return list;
        //         }
        //     }
        // }
        // return list;
    } 

    public int LongestSubArray(int[] arr, int k){
        int n = arr.length;
        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum += arr[i];
            int rem = sum - k;
            if(map.containsKey(rem)){
                int len = i-map.get(rem);
                ans = Math.max(ans, len);
            }
            // Base case not to add that sum that is present--> skip that
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return ans;
    }

    // LeetCode 560 Problem Solution
    public int findTotalKSumSubarray(int arr[], int k){
        int count=0,sum=0;
        HashMap<Integer,Integer> sumFreqMap = new HashMap<>();
        sumFreqMap.put(0,1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int rem = sum-k;
            count += sumFreqMap.getOrDefault(rem,0);
            sumFreqMap.put(sum,sumFreqMap.getOrDefault(sum,0)+1);
        }
        return count;
     }

    public static void main(String[] args) {
        SubArrayPatterns obj = new SubArrayPatterns();
        int[] arr = {2,8,2,6,-6,3,2};
        int[] arr1 = {1,2,3,7,5};
        int[] arr2 = {10, 5, 2, 7, 1, -10};
        int[] arr3 = {1,-1,0};
        // int[] arr = {2,8,2};
        System.out.println(obj.kSumSubarrayIsPresent(arr, 5));
        System.out.println(obj.indexOfSubset(arr1, 12));
        System.out.println(obj.LongestSubArray(arr2, 15));
        System.out.println(obj.findTotalKSumSubarray(arr3,0));
    }
}
