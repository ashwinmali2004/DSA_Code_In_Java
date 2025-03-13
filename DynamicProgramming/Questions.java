package DynamicProgramming;
 
import java.util.*;

public class Questions {

    public static void main(String[] args) {
        
    }
    // 509 fibonnaci number
    // T->O(N) using dp else normal is O(2^n)
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return recur(n, dp);
    }

    public int recur(int n, int dp[]){
        if(n<=1){
            dp[n] = n;
            return dp[n];
        }

        if(dp[n]!=-1){
            return dp[n];
        }
        
        dp[n]=fib(n-1)+fib(n-2);
        return dp[n];
    }

    // 70 Climbing Stairs
    // Using the concept of the fibonnaci but the base condition will be from 1 to n

    // 338 counting bits
}