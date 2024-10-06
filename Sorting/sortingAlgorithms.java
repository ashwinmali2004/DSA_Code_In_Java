package Sorting;

public class sortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = { 9, 6, 2, 4, 7, 1 };
        printArray(arr, "Original array");
        // insertionSort(arr);
        // selectionSort(arr);
        // bubbleSort(arr);
        // brickSort(arr);
        // countSort(arr);
        // pigeonholeSort(arr);
        cycleSort(arr);
        printArray(arr, "Sorted array");
    }

    public static void printArray(int[] arr, String message) {
        System.out.println("Printing " + message);
        for (int a : arr) {
            System.out.print(a + ",");
        }
        System.out.println();
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        // Time-complexity:O(n^2) Space-complexity:O(1)
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minEle = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < minEle) {
                    minEle = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 2; i++) {
            boolean flag = false; // for the optimization of the code
            for (int j = 0; j <= n - 2 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
                if (flag = false)
                    break;
            }
            // printArray(arr, "After pass"+i); //optimization of the code checked!
        }
    }

    public static void brickSort(int arr[]) {
        int n = arr.length;
        boolean isSorted = false;
        while (!isSorted) {
            boolean flag = false;
            // For the Even Index (Even index Swapping)
            for (int i = 0; i <= n - 2; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = true;
                }
            }
            // For the Odd Index (Odd index Swapping)
            for (int i = 1; i <= n - 2; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = true;
                }
            }
            if (!flag) {
                isSorted = true;
                break;
            }
        }
    }

    public static void countSort(int arr[]) {
        // It cant handle negative numbers
        // It takes Maximum Sapce comlexity which is not good

        int n = arr.length;
        int k = Integer.MIN_VALUE;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) {
                k = arr[i];
            }
        }

        if (k == Integer.MIN_VALUE) {
            return;
        }

        int countArr[] = new int[k + 1];

        for (int i = 0; i < n; i++) {
            int index = arr[i];
            countArr[index] += 1;
        }

        for (int i = 1; i <= k; i++) {
            countArr[i] += countArr[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            int countVal = --countArr[val];
            res[countVal] = val;
        }
        printArray(res, "After CountSort:");

    }

    // Sorting->

    public static void countingSortWithDigit(int arr[], int digit) {
        // find K,
        int n = arr.length;
        int k = 9;
        int res[] = new int[n];

        int countArr[] = new int[k + 1];

        System.out.println("value of digit is " + digit);
        // find the frequency
        for (int i = 0; i < n; i++) {
            int index = (arr[i] / digit) % 10;
            System.out.println("element is " + arr[i] + "digit is " + index);
            countArr[index] += 1;
        }
        printArray(countArr, "count array");

        // find cumulative frequency
        for (int i = 1; i <= k; i++) {
            countArr[i] += countArr[i - 1];
        }

        printArray(countArr, "count array with cumulative frequency");
        printArray(arr, "original array");
        // find the sorted array
        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            System.out.println("Value is " + val);
            // a-- & --a
            int countIndex = (arr[i] / digit) % 10;
            System.out.println("Index in count array " + countIndex);
            int countVal = --countArr[countIndex];
            System.out.print("Element " + val + " placed at index " + countVal);
            res[countVal] = val;
        }

        // copy back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = res[i];
        }

        printArray(arr, "original array");

        // return res;
    }

    public static void radixSort(int arr[]) {
        int n = arr.length;
        int maxEl = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxEl) {
                maxEl = arr[i];
            }
        }
        if (maxEl == Integer.MIN_VALUE) {
            System.out.println("Empty array");
            return;
        }

        for (int digit = 1; maxEl / digit > 0; digit *= 10) {
            countingSortWithDigit(arr, digit);
        }

    }

    public static void pigeonholeSort(int arr[]){
        int n=arr.length;
        int maxEl=Integer.MIN_VALUE;
        int minEl=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>maxEl){
                maxEl=arr[i];
            }
            if(arr[i]<minEl){
                minEl=arr[i];
            }
        }
        if(maxEl == Integer.MIN_VALUE || minEl == Integer.MAX_VALUE){
            System.out.println("Empty Array");
            return;
        }

        int size = maxEl-minEl+1;
        int pigeonhole[] = new int[size];

        for(int i=0;i<n;i++){
            int index = arr[i] - minEl;
            pigeonhole[index]++;
        }

        int insertionIndex=0;
        for(int j=0;j<size;j++){
            while(pigeonhole[j]>0){
                arr[insertionIndex]=j+minEl;
                insertionIndex++;
                pigeonhole[j]--;
            }
        }
    }

    public static void cycleSort(int[] arr){
        int n=arr.length;
        int index=0;
        while(index<n){
            int element = arr[index];
            int actualPos = element-1;
            if(arr[index]<n && arr[index]!=arr[actualPos]){
                swap(arr,index,actualPos);
            }else{
                index++;
            }
        }
    }
}