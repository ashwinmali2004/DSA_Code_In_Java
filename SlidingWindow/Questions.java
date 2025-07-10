package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Note -->
/*
 * sliding window patterns-
 * 1> fixed size 
 * 2> fixed size + Queue
 * 3> fixed size + HashMap
 * 4> variable size 
 * 5> variable size + Queue
 * 6> variable size + HashMap
 * 
*/


public class Questions {
    public int maximumSumSubarray(int[] arr, int k) {
        int n = arr.length;
        if(n<k) return 0;
        
        int sum = 0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        
        int maxSum = sum;
        int j=k;
        for(int i=0;i<n-k;i++){
            sum += arr[j++]-arr[i];
            maxSum=Math.max(sum, maxSum);
        }
        
        return maxSum;
    }

    static List<Integer> firstNegInt(int arr[], int k) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        if(n<k){
            return res;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<k;i++){
            if(arr[i]<0){
                q.add(i);
            }
        }
        
        res.add(q.isEmpty()?0:arr[q.peek()]);
        
        for(int i=k;i<n;i++){
            if(!q.isEmpty() && q.peek()<=i-k){
                q.poll();
            }
            if(arr[i]<0){
                q.add(i);
            }
            res.add(q.isEmpty()?0:arr[q.peek()]);
        }
        return res;
    }

    public int findMinDiff(ArrayList<Integer> arr, int m) {
        Collections.sort(arr);
        int sum = arr.get(m-1)-arr.get(0);
        int minSum = sum;
        for(int i=m;i<arr.size();i++){
            sum = arr.get(i)-arr.get(i-m+1);
            minSum = Math.min(sum, minSum);
        }
        return minSum;
    }

    public static int smallestSubWithSum(int x, int[] arr) {
        int maxLength=Integer.MAX_VALUE;
        int n = arr.length;
        int sum =0;
        int j=0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            
            while(sum>x){
                if(sum > x) maxLength=Math.min(maxLength, i-j+1);
                sum-=arr[j++];
            }
        }
        return maxLength==Integer.MAX_VALUE?0:maxLength;
    }

    public int longestKSubstr(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength=-1;
        int j=0;
        for(int i=0;i<n;i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            
            while(map.size()>k){
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j))==0){
                    map.remove(s.charAt(j));
                }
                j++;
            }
            
            if(map.size()==k) maxLength=Math.max(maxLength, i-j+1);;
            
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int j = 0; 
        for (int i = 0; i < n; i++) {
        char c = s.charAt(i);
        map.put(c, map.getOrDefault(c, 0) + 1);
        
        while (map.get(c) > 1) {
            char leftChar = s.charAt(j);
            map.put(leftChar, map.get(leftChar) - 1);
            if (map.get(leftChar) == 0) {
                map.remove(leftChar);
            }
            j++;
        }

        maxLength = Math.max(maxLength, i - j + 1);
    }

    return maxLength;
    }

    int search(String pat, String txt) {
        int k = pat.length(); 
        int n = txt.length(); 

        if (k > n) return 0; 

        HashMap<Character, Integer> patMap = new HashMap<>();
        for (char ch : pat.toCharArray()) {
            patMap.put(ch, patMap.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> txtMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            char ch = txt.charAt(i);
            txtMap.put(ch, txtMap.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        if (patMap.equals(txtMap)) {
            count++;
        }

        for (int i = k; i < n; i++) {
            char newChar = txt.charAt(i);        
            char oldChar = txt.charAt(i - k);    
            
            txtMap.put(newChar, txtMap.getOrDefault(newChar, 0) + 1);
            
            if (txtMap.get(oldChar) == 1) {
                txtMap.remove(oldChar); 
            } else {
                txtMap.put(oldChar, txtMap.get(oldChar) - 1);
            }

            if (txtMap.equals(patMap)) {
                count++;
            }
        }

        return count;
    }

        public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int have = 0, need = mapT.size();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (mapT.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == mapT.get(c).intValue()) {
                    have++;
                }
            }

            while (have == need) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                if (mapT.containsKey(leftChar)) {
                    window.put(leftChar, window.get(leftChar) - 1);
                    if (window.get(leftChar) < mapT.get(leftChar)) {
                        have--;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    // 239
        public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n-k+1];

        if(n==0) return res;

        Deque<Integer> deque = new ArrayDeque<Integer>();
        int index = 0;

        while(index<k){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[index]){
                deque.pollLast();
            }
            deque.offerLast(index);
            index++;
        }

        res[0] = nums[deque.peekFirst()];

        for(int i=0;i<n-k+1;i++){
            if(!deque.isEmpty() && deque.peekFirst()<=i-1){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i+k-1]){
                deque.pollLast();
            }
            deque.offerLast(i+k-1);
            res[i] = nums[deque.peekFirst()];
        }
        return res;
    }
}
