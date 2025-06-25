package Arrays.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // 54 spiral matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0;

        int row=0, col=0;
        for(int i=0;i<n*m;i++){
            ans.add(matrix[row][col]);
            visited[row][col]=true;

            int nextRow = row+directions[dir][0];
            int nextCol = col+directions[dir][1];

            if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m && !visited[nextRow][nextCol]){
                row = nextRow;
                col = nextCol;
            }else{
                dir = (dir+1)%4;
                row += directions[dir][0];
                col += directions[dir][1];
            }
        }
        return ans;
    }

    // 59 Spiral matrix II
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0;
        int row = 0;
        int col = 0;
        for(int i=1;i<=n*n;i++){
            matrix[row][col] = i;

            int newRow = row + directions[dir][0];
            int newCol = col + directions[dir][1];

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || matrix[newRow][newCol] != 0) {
                dir = (dir + 1) % 4;
                newRow = row + directions[dir][0];
                newCol = col + directions[dir][1];
            }

            row = newRow;
            col = newCol;
        }
        return matrix;
    }
}
