package Arrays.Matrix;

public class SearchIn2dMatrix {

    // 74 leetcode
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;
        int end = n*m-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            int r = mid/m;
            int c = mid%m;
            if(matrix[r][c]<target){
                start = mid+1;
            }else if(matrix[r][c]>target){
                end = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }

    // 240 leetcode
    public boolean searchMatrixII(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int r = 0;
        int c = m-1;
        while(r<n && c>=0){
            if(matrix[r][c]==target){
                return true;
            }else if(matrix[r][c]>target){
                c=c-1;
            }else{
                r=r+1;
            }
        }
        return false;
    }
}
