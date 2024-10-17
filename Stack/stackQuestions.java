package Stack;
import java.util.*;

public class stackQuestions {

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
    public static void main(String[] args) {
        // to count the number of reversals to take for the balancing the String
        int ans = countRev("}{{}}{{{");
        System.out.println(ans);

        // to count the minimum no of swaps
        System.out.println(minSwaps("][]["));
    }
}
