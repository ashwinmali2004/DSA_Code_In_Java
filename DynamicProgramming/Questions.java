package DynamicProgramming;

import java.util.*;

public class Questions {

    public static void main(String[] args) {

    }

    // 509 fibonnaci number
    // T->O(N) using dp else normal is O(2^n)
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return recur(n, dp);
    }

    public int recur(int n, int dp[]) {
        if (n <= 1) {
            dp[n] = n;
            return dp[n];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }

    // 70 Climbing Stairs
    // Using the concept of the fibonnaci but the base condition will be from 1 to n

    // 338 counting bits
    // O(n)
    public int[] countBits(int n) {
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    // 746 min cost climbing stairs
    // dp-->
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return recur(n, cost, dp);
    }

    public int recur(int n, int cost[], int dp[]) {
        // base case
        if (n == 0 || n == 1) {
            dp[n] = 0;
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int oneStep = cost[n - 1] + recur(n - 1, cost, dp);
        int twoStep = cost[n - 2] + recur(n - 2, cost, dp);
        dp[n] = Math.min(oneStep, twoStep);
        return dp[n];
    }

    // bottom-up space optimized

    // public int minCostClimbingStairs(int[] cost) {
    // int n = cost.length;
    // int prev1 = 0;
    // int prev2 = 0;
    // int ans = 0;
    // for(int i=2;i<=n;i++){
    // int oneStep = cost[i-1]+prev1;
    // int twoStep = cost[i-2]+prev2;
    // ans = Math.min(oneStep, twoStep);
    // prev2 = prev1;
    // prev1 = ans;
    // }
    // return ans;
    // }

    // 198 House Robber
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return recur(nums, n, dp);
    }

    // shifting logic is used as there could be a negative index--
    public int recur(int nums[], int index, int[] dp) {
        // base case
        if (index == 1) {
            dp[index] = nums[0];
            return nums[0];
        }

        if (index == 0) {
            dp[index] = 0;
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }
        // pick and nopick
        int pick = nums[index - 1] + recur(nums, index - 2, dp);
        int noPick = 0 + recur(nums, index - 1, dp);
        dp[index] = Math.max(pick, noPick);

        return dp[index];
    }
    // state approch or tabulation approch
    /*
     * public int rob(int[] nums){
     * int n = nums.length;
     * int dp[] = new int[n+1];
     * dp[0]=0;
     * dp[1]=nums[0];
     * for(int state=2;state<n+1;state++){
     * int pick=nums[state-1]+dp[state-2];
     * int noPick=0+dp[state-1];
     * dp[state]=Math.max(pick, noPick);
     * }
     * return dp[n];
     * }
     */

    //  213 House Robber II
    // skip 1st one and skip last one than compare both

    // public int rob1(int[] nums) {
    //     int n=nums.length;
    //     int prev2=0;
    //     int prev1=nums[0];
    //     int ans=nums[0];
    //     for(int i=2;i<n+1;i++){
    //         int pick=nums[i-1]+prev2;
    //         int noPick=prev1;
    //         ans=Math.max(pick, noPick);
    //         prev2=prev1;
    //         prev1=ans;
    //     }
    //     return ans;
    // }
    
    // public int rob(int[] nums) {
    // int n=nums.length;
    // if(n==1){
    //     return nums[0];
    // }
    // int num1[] = new int[n-1];
    // int num2[] = new int[n-1];
    // int j=0;
    // int k=0;
    // for(int i=0;i<n;i++){
    //     if(i!=0){
    //         num1[j] = nums[i];
    //         j++;
    //     }
    //     if(i!=n-1){
    //         num2[k] = nums[i];
    //         k++;
    //     }
    // }
    // return Math.max(rob1(num1), rob1(num2));
    // }

    // 2d DP
    // gfg-- check if there exist a subsequence with sum k
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
        int dp[][] = new int[N][K+1];
        return recur(arr, K, N-1,dp);
    }
    //  0 -> not visited
    //  1 -> true
    //  2 -> false
    public static boolean recur(int arr[], int K, int index, int dp[][]){
        //base case
        if(K == 0){
            dp[index][K] = 1;
            return true;
        }
        if(index == 0){
            if(K == arr[index]) {
                dp[index][K] = 1;
                return true;
            }
            dp[index][K] = 2;
            return false;
        }

        if(dp[index][K]!=0){
            return (dp[index][K] == 1);
        }

        boolean pick = false;
        if(arr[index]<= K){
            pick = recur(arr, K-arr[index], index-1,dp);
            if (pick){
                dp[index][K] = 1;
                return true;
            }
        }
        boolean noPick = recur(arr, K, index-1,dp);
        dp[index][K] = (noPick==true)?1:2;
        return noPick;
    }

    // perfect Sum Problem--gfg
    // public int perfectSum(int[] nums, int target) {
    //     // code here
    //     int n = nums.length;
    //     int dp[][] = new int[n][target+1];
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<target+1;j++){
    //             dp[i][j] = -1;
    //         }
    //     }
    //     return recur(nums,target, n-1, dp);
    // }
    // int recur(int nums[], int target, int index, int dp[][]){
    //     //base case
    //     if(index==0){
    //         if(target == 0 && nums[index] == 0) {
    //             dp[index][target] = 2;
    //             return 2;
    //         }
    //         else if(target == 0) {
    //             dp[index][target] = 1;
    //             return 1;
    //         }
    //         else if(target == nums[index]) {
    //             dp[index][target] = 1;
    //             return 1;
    //         }
    //         else {
    //             dp[index][target] = 0;
    //             return 0;
    //         }
    //     }

    //     if(dp[index][target]!=-1){
    //         return dp[index][target];
    //     }

    //     int pick = 0;
    //     if(nums[index]<=target){
    //         pick = recur(nums, target - nums[index], index-1, dp);
    //     }

    //     int noPick = recur(nums, target , index-1, dp);
    //     dp[index][target] = pick + noPick;
    //     return dp[index][target];

    // }

}