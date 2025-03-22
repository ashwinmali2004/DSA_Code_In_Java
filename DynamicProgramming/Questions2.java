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

    // 1092 shortest common supersequence
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = longestCommonSubsequence(str1, str2);
        int n = dp.length;
        int m = dp[0].length;
        int i=n-1;
        int j=m-1;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){ //lcs
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            }else {
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i>0) {
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0) {
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }

    public int[][] longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        recur(n,m,text1,text2,dp);
        return dp;
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

    // 300 longest increasing subsequence
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        Arrays.fill(lis, 1);
        int maxLen=1;
        for(int i=1;i<n;i++){
            for(int p=0;p<i;p++){
                if(nums[p] < nums[i]){
                    lis[i] = Math.max(lis[i], 1 + lis[p]);
                }
            }
            if(lis[i] > maxLen){
                maxLen = lis[i];
            }
        }
        return maxLen;
    }

    // 646 maximum length of pair chain
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[0] - b[0]);
        int n = pairs.length;
        int lis[] = new int[n];
        Arrays.fill(lis, 1);
        int maxLen=1;
        for(int i=1;i<n;i++){
            for(int p=0;p<i;p++){
                if(pairs[p][1] < pairs[i][0]){
                    lis[i] = Math.max(lis[i], 1 + lis[p]);
                }
            }
            if(lis[i] > maxLen){
                maxLen = lis[i];
            }
        }
        return maxLen;
    }

    // 62 unique paths
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(m, n, dp);
    }

    public int recur(int m, int n, int dp[][]){
        if(m==1 && n==1){
            dp[m][n] = 1;
            return 1;
        }
        if(m==0 || n==0){
            dp[m][n] = 0;
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        dp[m][n] = recur(m-1,n,dp) + recur(m,n-1,dp);
        return dp[m][n];
    }

    // 63 unique paths II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recur(m - 1, n - 1, obstacleGrid, dp);
    }

    public int recur(int m, int n, int[][] obstacleGrid, int[][] dp) {
        if (m < 0 || n < 0 || obstacleGrid[m][n] == 1) {
            return 0; // Out of bounds or obstacle
        }
        if (m == 0 && n == 0) {
            return 1; // Reached start point
        }
        if (dp[m][n] != -1) {
            return dp[m][n]; // Memoization
        }
        dp[m][n] = recur(m - 1, n, obstacleGrid, dp) + recur(m, n - 1, obstacleGrid, dp);
        return dp[m][n];
    }
    
}
