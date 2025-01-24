package HashMap;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentElement {
    public int repeataiveElement(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        // for (int num : arr) {
        // map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                int freq = map.get(arr[i]);
                freq++;
                map.put(arr[i], freq);
            } else {
                map.put(arr[i], 1);
            }
        }

        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                maxValue = Math.max(maxValue, entry.getKey());
            }
        }

        return maxValue;
    }

    // Another Way can Be->
    public static int mostFrequentElement(int arr[]) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int ans = -1;
        int maxFreq = 0;
        for (int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
            if (freqMap.get(arr[i]) > maxFreq) {
                maxFreq = freqMap.get(arr[i]);
                ans = arr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MostFrequentElement obj = new MostFrequentElement();
        int[] arr = { 1, 3, 2, 2, 1, 4, 1 };
        System.out.println(obj.repeataiveElement(arr));
    }
}
