package Sorting;

// O(nlogn) --> O(nlogn)
// O(n)

public class MergeSort {
    static void printarray(int A[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    static void merge(int A[],int mid, int low, int high){
        int i,j,k;
        int B[]=new int[100];
        i=low;
        j=mid+1;
        k=low;

        while(i<=mid && j<=high){
            if(A[i]<A[j]){
                B[k]=A[i];
                i++;
                k++;
            }
            else{
                B[k]=A[j];
                j++;
                k++;
            }
        }
        // left side 
        while(i<=mid){
            B[k]=A[i];
            k++;
            i++;
        }
        // right
        while(j<=high){
            B[k]=A[j];
            k++;
            j++;
        }
        // copy into original array
        for(int l =low;l<=high;l++){
            A[l]=B[l];
        }
    }
    
    static void mergeSort(int A[],int low,int high){
        int mid;
        if(low<high){
            mid =(low+high)/2;
            mergeSort(A, low, mid);
            mergeSort(A, mid+1, high);
            merge(A, mid, low, high);
        }
    }
    public static void main(String[] args) {
        int A[]={12,54,65,7,23,9};
        int n=6;
        System.out.println("Given Array ->");
        printarray(A,n);
        mergeSort(A,0,5);
        System.out.println("Sorted Array ->");
        printarray(A,n);
    }
}
