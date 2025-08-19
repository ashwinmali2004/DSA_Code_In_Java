import java.util.*;

public class QuestionsBacktracking {
    public static void main(String[] args) {
        
    }

    // Permutation Leetcode 46 O(nxn!)
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        solve(nums, 0);
        return ans;
    }

    public void solve(int[] nums, int ind){
        if(ind==nums.length){
            List<Integer> sub = new ArrayList<>();
            for(int e : nums){
                sub.add(e);
            }
            ans.add(sub);
            return;
        }
        for(int i=ind;i<nums.length;i++){
            swap(nums, i, ind);
            solve(nums, ind+1);
            swap(nums, i, ind);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Leetcode Palindrom Partitioning 131
    List<List<String>> res = new ArrayList<>();
    int l;
    public List<List<String>> partition(String s) {
        l = s.length();
        recur(s, 0, new ArrayList<String>());
        return res;
    }

    public void recur(String s, int ind, List<String> cur){
        if(ind==l){
            res.add((new ArrayList<>(cur)));
            return;
        }
        for(int i=ind;i<l;i++){
            if(isPalindrome(s, ind, i)){
                cur.add(s.substring(ind, i+1));
                recur(s, i+1, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Leetcode Letter Combinations of a Phone Number 17
    List<String> list = new ArrayList<>();
    HashMap<Integer, String> map = new HashMap<>();
    int n;
    public List<String> letterCombinations(String digits) {
        n = digits.length();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        if(n==0  || digits==null) return list;
        recursion(digits, 0, new StringBuilder());
        return list;
    }
    
    public void recursion(String digits, int ind, StringBuilder str){
        if(ind==n){
            list.add(str.toString());
            return;
        }
        String s = map.get(Integer.parseInt(String.valueOf(digits.charAt(ind))));
        for(char c : s.toCharArray()){
            str.append(c);
            recursion(digits, ind+1, str);
            str.deleteCharAt(str.length()-1);
        }
    }

    
}