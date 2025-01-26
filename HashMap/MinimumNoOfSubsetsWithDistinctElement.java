package HashMap;

import java.util.HashMap;

public class MinimumNoOfSubsetsWithDistinctElement {
    public int minimumSubset(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int a : arr){
            map.put(a, map.getOrDefault(a,0)+1);
            ans = Math.max(ans,map.get(a));
        }
        // for(int i=0;i<arr.length;i++){
        //     ans = Math.max(ans,map.get(arr[i]));
        // }
        return ans;
    }

    public static void main(String[] args) {
        MinimumNoOfSubsetsWithDistinctElement obj = new MinimumNoOfSubsetsWithDistinctElement();
        // int[] arr = {1,2,3,4}; // 1
        int[] arr = {1,2,3,3};
        System.out.println(obj.minimumSubset(arr));
    }
}
