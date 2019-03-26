package leetcode.solved.easy;


/**
 * https://leetcode.com/problems/toeplitz-matrix/
 */
public class Easy_Q766_ToeplitzMatrix {
    int rows;
    int cols;

    public boolean check(int[][] matrix, int i, int j, int val) {
        while(true) {
            if(i >= rows || j >= cols) {
                break;
            }
            if(matrix[i++][j++] != val) {
                return false;
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        for(int i = 0; i < rows; i++) {
            int val = matrix[i][0];
            if(check(matrix, i, 0, val) == false) {
                return false;
            }
        }
        for(int j = 0; j < cols; j++) {
            int val = matrix[0][j];
            if(check(matrix, 0, j, val) == false) {
                return false;
            }
        }
        return true;
    }
}
