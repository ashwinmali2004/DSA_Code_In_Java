package HashMap;

import java.util.*;

public class ArraySubsetOfAnotherArray {

    public String isSubset( long a1[], long a2[], long n, long m) {
        HashMap<Long,Integer> freqMap = new HashMap<>();
        for(long element : a1){
            freqMap.put(element, freqMap.getOrDefault(element,0)+1);
        }

        for(long element : a2){
            //  if(freqMap.containsKey(element) && freqMap.get(element)>0){
            if(freqMap.getOrDefault(element,0)>0){
                freqMap.put(element, freqMap.get(element)-1);
            }else {
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        ArraySubsetOfAnotherArray obj = new ArraySubsetOfAnotherArray();
        long[] arr = {1,2,3,4,5};
        long[] arr1 = {1,2,3};
        System.out.println(obj.isSubset(arr,arr1,5,3));
    }
}

