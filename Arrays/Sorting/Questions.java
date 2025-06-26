package Sorting;

import java.util.ArrayList;
import java.util.List;

// All duplicacy Questions can be done by the cycle sort concept with constant space + O(n)time
public class Questions {

    // Q287 Leetcode
    public int findDuplicate(int[] nums) {
        int index = 0;
        int n = nums.length;
        while(index<n){
            int element = nums[index];
            int actualPosition = element-1;
            if(nums[index]!=nums[actualPosition]){
                swap(nums, index, actualPosition);
            }else{
                index++;
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]-1!=i){
                return nums[i];
            }
        }
        return -1; 
    }  
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 


    // Q448 Leetcode
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int index = 0;
        int n = nums.length;
        while(index<n){
            int element = nums[index];
            int actualPosition = element-1;
            if(nums[index]!=nums[actualPosition]){
                swapa(nums, index, actualPosition);
            }else{
                index++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                ans.add(i+1);
            }
        }
        return ans;
    }
    public void swapa(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Q442 Leetcode Find all duplicates same as above
    public List<Integer> findDuplicates(int[] nums) {
        int index = 0;
        int n = nums.length;
        while(index<n){
            int element = nums[index];
            int actualPosition = element-1;
            if(nums[index]!=nums[actualPosition]){
                swapb(nums, index, actualPosition);
            }else{
                index++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
    public void swapb(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
