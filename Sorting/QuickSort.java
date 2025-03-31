package Sorting;

// O(nlogn)-->O(n2)
// O(n)
public class QuickSort {
    static void printarray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low+1;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i < high) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[low] as pivot to j
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }

    static void quicksort(int arr[], int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quicksort(arr, low, partitionIndex - 1);
            quicksort(arr, partitionIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 54, 65, 7, 23, 9};
        int n = arr.length; // Use the length of the array instead of hardcoding the size
        System.out.println("Given Array ->");
        printarray(arr, n);
        quicksort(arr, 0, n - 1);
        System.out.println("Sorted Array ->");
        printarray(arr, n);
    }
}
