import java.util.*;
public class QuestionsPickNoPick {
    static ArrayList<String> li = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        sub("abc", 0, 3, "");
        System.out.println(li);
        int[] nums = {1,2,3,4,5,6};
        subK(nums,0,6,new ArrayList<>(), 5, 0);
        System.out.println(res);
    }

    // Print all subsequences of a string GFG
    public static void sub(String str, int ind, int n, String res){
        if(ind==n){
            li.add(res);
            return;
        }
        sub(str, ind+1, n, res+str.charAt(ind));  //pick
        sub(str, ind+1, n, res); //noPick
    }

    // subsequences sum equal to k GFG
    public static void subK(int[] nums, int ind, int n, ArrayList<Integer> ans, int target, int sum){
        if(ind == n){
            if (sum == target) {
                res.add(new ArrayList<>(ans)); 
            }
            return;
        }

        ans.add(nums[ind]);
        subK(nums, ind+1, n, ans, target, sum+nums[ind]);

        ans.remove(ans.size()-1);
        subK(nums, ind+1, n, ans, target, sum);
    }

    // Comination Sum I 39
    List<List<Integer>> ans = new ArrayList<>();
    int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;
        solve(candidates, 0, target, new ArrayList<>());
        return ans;
    }

    public void solve(int[] candidates, int ind, int target, ArrayList<Integer> list){
        if(ind==n){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        // pick
        if(candidates[ind]<=target){
            list.add(candidates[ind]);
            solve(candidates, ind, target-candidates[ind], list);
            list.remove(list.size()-1);
        }
        // noPick
        solve(candidates, ind+1, target, list);
    }

    

}
