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
    
    // rod cutting gfg
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(n,m,text1,text2,dp);
    }
    int recur(int i, int j, String text1, String text2, int dp[][]){
        //base case
        if(i==0 || j==0){
            dp[i][j] = 0;
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(text1.charAt(i-1) == text2.charAt(j-1)){
            dp[i][j] = 1+ recur(i-1,j-1,text1,text2,dp);
            return dp[i][j];
        }else{
            int case1 = recur(i-1,j,text1,text2,dp);
            int case2 = recur(i,j-1,text1,text2,dp);
            dp[i][j] = Math.max(case1,case2);
            return dp[i][j];
        }

    }

    // 1143 longest common subsequence
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(n,m,text1,text2,dp);
    }
    int recur(int i, int j, String text1, String text2, int dp[][]){
        //base case
        if(i==0 || j==0){
            dp[i][j] = 0;
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(text1.charAt(i-1) == text2.charAt(j-1)){
            dp[i][j] = 1+ recur(i-1,j-1,text1,text2,dp);
            return dp[i][j];
        }else{
            int case1 = recur(i-1,j,text1,text2,dp);
            int case2 = recur(i,j-1,text1,text2,dp);
            dp[i][j] = Math.max(case1,case2);
            return dp[i][j];
        }

    }

    // 516 longest palindromic common subsequence
    public int longestPalindromeSubseq(String s) {
        String text1 = s;
        StringBuilder str = new StringBuilder(s);
        String text2 = str.reverse().toString();
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(n,m,text1,text2,dp);
    }
    int recur(int i, int j, String text1, String text2, int dp[][]){
        //base case
        if(i==0 || j==0){
            dp[i][j] = 0;
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(text1.charAt(i-1) == text2.charAt(j-1)){
            dp[i][j] = 1+ recur(i-1,j-1,text1,text2,dp);
            return dp[i][j];
        }else{
            int case1 = recur(i-1,j,text1,text2,dp);
            int case2 = recur(i,j-1,text1,text2,dp);
            dp[i][j] = Math.max(case1,case2);
            return dp[i][j];
        }

    }

    
}
