package DynamicProgramming;

public class Questions2 {
    public static void main(String[] args) {
        
    }
    // 0/1 knapsack problem GFG
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<W+1;j++){
                dp[i][j]=-1;
            }
        }
        return recur(W, val, wt, n-1, dp);
    }
    static int recur(int W, int val[], int wt[], int index, int[][] dp){
        // base case
        if(W==0){
            dp[index][W] = 0;
            return 0;
        }
            
        if(index==0){
            if(wt[index]<=W){
                dp[index][W] = val[index];
                return val[index];
            }else{
                dp[index][W] = 0;
                return 0;
            }
        }
        
        if(dp[index][W] != -1){
            return dp[index][W];
        }
        
        int pick =0;
        if(wt[index]<=W){
            pick=val[index]+recur(W-wt[index], val, wt, index-1, dp);
        }
        int noPick = 0 + recur(W, val, wt, index-1, dp);
        
        dp[index][W] = Math.max(pick, noPick);
        return dp[index][W];
    }

    // 322 coin change and 518 coin change II
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int prev[] = new int[amount+1];
        for(int a=0;a<amount+1;a++){
            if(a % coins[0]==0){
                prev[a] = a / coins[0];
            }else{
                prev[a] = (int)(1e9);
            }
        }

        for(int i=1;i<n;i++){
            int cur[] = new int[amount+1];
            for(int a=0;a<amount+1;a++){
                int pick = (int)(1e9);
                if(a >= coins[i]){
                    pick = 1 + cur[a-coins[i]]; 
                }
                int noPick = prev[a];
                cur[a] = Math.min(pick, noPick);
            }
            prev = cur;
        }

        if(prev[amount] == (int)(1e9)){
            return -1;
        }
        return prev[amount];
    }
    
}
