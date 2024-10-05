package Searching;
public class kthElement {
    public static void main(String[] args) {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int k = 5;

        System.out.println(kElement(arr1, arr2, k));
    }

    public static int kElement(int[] arr1, int[] arr2, int target) {
        int index1 = 0, index2 = 0;
        int ans = -1;

        // Merge the arrays until we reach the k-th element
        for (int i = 0; i < target; i++) {
            if (index1 >= arr1.length) { // If arr1 is exhausted
                ans = arr2[index2++];
            } else if (index2 >= arr2.length) { // If arr2 is exhausted
                ans = arr1[index1++];
            } else if (arr1[index1] < arr2[index2]) {
                ans = arr1[index1++];
            } else {
                ans = arr2[index2++];
            }
        }

        return ans;
    }
}
