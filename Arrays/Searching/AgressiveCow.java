package Arrays.Searching;

import java.util.*;
public class AgressiveCow {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[] stalls = {1,2,4,8,9};
        System.out.println(solve(n,k,stalls));
    }
    public static int solve(int n, int cows, int[] stalls){
        
        if(stalls.length<cows){
            return -1;
        }

        Arrays.sort(stalls);

        int start = 1;
        int end = stalls[n-1] - stalls[0];
        int ans =-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            // if possible than increase the distance
            if(isAllocationPossible(stalls,mid,cows)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }

    public static boolean isAllocationPossible(int[] stalls, int midDist, int cows){
        int cowCount = 1;
        int lastcowDist = stalls[0];
        for(int i=1;i<stalls.length;i++){
            // check if distance is maintained
            // then increase count of cow and assign new location
            if(stalls[i] - lastcowDist >= midDist){
                cowCount+=1;
                lastcowDist = stalls[i];
            }
            if(cowCount>=cows){
                return true;
            }
        }
        return false;
    }
}
