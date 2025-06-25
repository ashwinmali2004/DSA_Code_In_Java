package Arrays.Matrix;

public class MedianInMatix {
    int medianB(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int[] flat = new int[n * m];

        for (int i = 0; i < n * m; i++) {
            int row = i / m;
            int col = i % m;
            flat[i] = mat[row][col];
        }
    
        Arrays.sort(flat);
        
        return flat[(m*n)/2];
    }

    

    // Using Binary Search with constant space with 2logn solution
    int median(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int N = m*n;
        int medianIndex = N/2;
        int start = 1;
        int end = 2000;
        while(start<=end){
            int assumeMedian = start+(end-start)/2;
            int lesserElements = isPossible(mat, assumeMedian);
            if(lesserElements<=medianIndex){
                start = assumeMedian+1;
            }else{
                end = assumeMedian-1;
            }
        }
        return start;
    }
    
    int isPossible(int mat[][], int assumeMedian){
        int noOfElements = 0;
        for(int i=0;i<mat.length;i++){
            int start = 0;
            int end = mat[i].length-1;
            while(start<=end){
                int mid = start+(end-start)/2;
                if(mat[i][mid]<=assumeMedian){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
            noOfElements += start;
        }
        return noOfElements;
    }

// Exact Similar pattern Questions --->
    // Q378 kth smallest element insorted matrix
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int N = m*n;
        int start = matrix[0][0];
        int end = matrix[n-1][m-1];
        while(start<=end){
            int mid = start+(end-start)/2;
            int countNumbers = isPossibleK(matrix, mid);
            if(countNumbers<=k-1){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }

    int isPossibleK(int matrix[][], int assumeK){
        int count = 0;
        for(int i=0;i<matrix.length;i++){
            int start = 0;
            int end = matrix[i].length-1;
            while(start<=end){
                int mid = start+(end-start)/2;
                if(matrix[i][mid]<=assumeK){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
            count+=start;
        }
        return count;
    }

}
