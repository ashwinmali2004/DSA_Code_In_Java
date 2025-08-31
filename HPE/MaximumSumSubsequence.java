package HPE;

public class MaximumSumSubsequence {
    static int maxSumIS(int[] arr) {
        int ans = 0;
        
        int[] dp = new int[arr.length];
        
        // Compute maximum sum for each 
        // index and compare it with ans.
        for (int i = 0; i < arr.length; i++) {
            dp[i] = arr[i];
            
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], arr[i] + dp[j]);
                }
            }
            
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100};
        System.out.println(maxSumIS(arr));
    }
}
