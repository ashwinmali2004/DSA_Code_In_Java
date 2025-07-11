package Stack;
import java.util.*;

public class stackQuestions {


    // 20 Leetcode Valid paranthese
    // count the reversals on gfg
    public static int countRev (String s)
    {
        if(s.length()%2!=0){
            return -1;
        }

        int closing = 0, opening = 0;  
        int ans = 0;      
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty()){
                if(stack.peek()=='{' && s.charAt(i)=='}'){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }

        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c=='{'){
                opening++;
            }else{
                closing++;
            }
        }
        ans += (opening+1)/2 + (closing+1)/2;
        return ans;
    }

    // another approch for above to reduce the traversal 
    public static int countRev2 (String s)
    {
        if(s.length()%2!=0){
            return -1;
        }
        
        int ans = 0, open = 0, close=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='{'){
                open+=1; 
            } else {             
                if(open<=0) {
                    close++;
                } else {
                    open--;
                }
            }
        }

        ans = (int)(Math.ceil(open/2.0) + Math.ceil(close/2.0));
        return ans;
    }

    // Q921 Leetcode
        public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                open++;
            }else{
                if(open>0){
                    open--;
                }else{
                    close++;
                }
            }
        }
        return open+close;
    }

    // Q1963 Leetcode
    public static int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                if(!stack.isEmpty() && stack.peek()=='['){
                    stack.pop();
                }
                else{
                    count++;
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        return (count+1)/2;
    }

    // gfg minimumswap for balancing adjacent
    static int minimumNumberOfSwaps(String s) {
        int open = 0, close = 0, unbalanced = 0, ans = 0;
        for(char c : s.toCharArray()){
            if(c=='['){
                open++;
                if(unbalanced>0){
                    ans += unbalanced;
                    unbalanced--;
                }
            }else{
                close++;
                unbalanced = close-open;
            }
        }
        return ans;
    }

    // Online Stock span (901)
    // next Greater Element gfg
    // help classmate gfg
    // next Greater ElementII (503) leetcode
    // Area of Hiistogram =>prevSmaller+nextSmaller element (84) leetcode
    // Area of Rectangle => (85) AreaOf Histogram leetcode


    // Q32 Longest Valid Parantheses(Leetcode)
        // Applying solution with the custom Stack-->
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        int stack[] = new int[n+1];
        int index = -1;
        int maxLength = 0;
        stack[++index]=-1;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack[++index]=i;
            } else {
                index--;
                if (index==-1) {
                    stack[++index]=i;
                } else {
                    maxLength = Math.max(maxLength, i - stack[index]);
                }
            }
        }
        
        return maxLength;
    }

// Using Without Custom Stack
    // public int longestValidParentheses(String s) {
    //     if (s.length() <= 1) return 0;
    //     Stack<Integer> stack = new Stack<>();
    //     stack.push(-1);
    //     int maxLength = 0;
        
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (c == '(') {
    //             stack.push(i);
    //         } else {
    //             stack.pop();    
    //             if (stack.isEmpty()) {
    //                 stack.push(i);
    //             } else {
    //                 maxLength = Math.max(maxLength, i - stack.peek());
    //             }
    //         }
    //     }
        
    //     return maxLength;
    // }

    
    public static void main(String[] args) {
        // to count the number of reversals to take for the balancing the String
        int ans = countRev("}{{}}{{{");
        System.out.println(ans);

        // to count the minimum no of swaps
        System.out.println(minSwaps("][]["));
    }
}
