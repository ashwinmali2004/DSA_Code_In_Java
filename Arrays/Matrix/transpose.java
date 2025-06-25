package Arrays.Matrix;

public class transpose {

    // Leetcode 867 and also on gfg
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;
    }

    // leetcode rotate image clock wise 48 --->
        public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        transpose(matrix, n, m); 
        reverse(matrix, n, m);
    }

    public void reverse(int[][] matrix, int n, int m){
        for(int i=0;i<n;i++){
        int j=0;
            while(j<m/2){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
                j++;
            }
        }
    }

    public void swap(int[][] matrix, int i, int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }

    public void transpose(int[][] matrix, int n, int m){
        // swapping lower triangle to the lower triangle
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                swap(matrix, i, j);
            }
        }

        // swaping uper triangle to the lower triangle
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<m;j++){
        //         swap(matrix, i, j);
        //     }
        // }
    }

    // GFG rotate an image anticlock wise
    static void rotateby90(int mat[][]) {
        int n = mat.length;
        transPose(mat, n);
        reverse(mat, n);
    }
    
    static void transPose(int mat[][], int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                swap2(mat, i, j);
            }
        }
    }
    
    static void swap2(int mat[][], int i, int j){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }
    
    static void reverse(int mat[][], int n){
        for(int i=0;i<n;i++){
            int j=0;
            while(j<n/2){
                int temp = mat[j][i];
                mat[j][i] = mat[n-j-1][i];
                mat[n-j-1][i] = temp;
                j++;
            }
        }
    }
    
}
