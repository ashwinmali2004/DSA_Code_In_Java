public class QuestionsRecuresion {
    public static void main(String[] args) {
        // System.out.println(ways(2,2));
    }
    
    // decimal to binary on GFG
    static String decToBinary(int n) {
        if(n==0) return "";
        return decToBinary(n/2)+n%2;
    }

    // reverse a digit on GFG
    public int reverseDigits(int n) {
        return Integer.parseInt(rev(n));
    }
    public String rev(int n){
        if(n==0){
            return "";
        }
        return ""+n%10+rev(n/10);
    }
    // in above case if number if negative than at last (check<0) if yes than multiply by -1

    // reverse a string on GFG
    public static String reverseString(String s) {
        return fun(s, 0, "");
    }
    
    public static String fun(String s, int ind, String ans) {
        if (ind == s.length()) {
            return ans;
        }
        ans = s.charAt(ind) + ans;
        return fun(s, ind + 1, ans);
    }

    // Reverse a string LeetCode
    public void reverseString(char[] s) {
        reverseHelper(s, 0, s.length - 1);
    }

    private void reverseHelper(char[] s, int i, int j) {
        if (i >= j) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        reverseHelper(s, i + 1, j - 1);
    }

    // Tower Of Hanoi GFG
    int count=0;
    public int towerOfHanoi(int n, int from, int to, int aux) {
        if(n==0) return 0;
        count++;
        towerOfHanoi(n-1, from, aux, to);
        towerOfHanoi(n-1, aux, to, from);
        return count;
    }

    // Count all possible paths from top left to bottom righ
    static int ways(int m, int n){
        if (m == 0 || n == 0) {
            return 1;
        }
        return ways(m - 1, n) + ways(m, n - 1);
    }


}
