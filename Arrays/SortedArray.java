package Arrays;

public class SortedArray {
    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }

        boolean ascending = true;
        boolean descending = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                ascending = false;
            }
            if (arr[i] > arr[i - 1]) {
                descending = false;
            }
        }

        return ascending || descending;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {9,4,3,2,1};
        int[] arr3 = {9,4,3,3,6,2};
        System.out.println(isSorted(arr1));
        System.out.println(isSorted(arr2));
        System.out.println(isSorted(arr3));
    }
}
