package array;

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/
// Count Square Submatrices with All Ones

public class Q1277 {
    public int countSquares(int[][] matrix) {
        final int HEIGHT = matrix.length, WIDTH = matrix[0].length;
        final int MAX_SQUARE_LEN = Math.min(HEIGHT, WIDTH);
        int answer = 0;
        for (int l = 1; l <= MAX_SQUARE_LEN; l++) {
            for (int i = 0, iLen = HEIGHT - l; i <= iLen; i++) {
                for (int j = 0, jLen = WIDTH - l; j <= jLen; j++) {
                    if (matrix[i][j] != 0) {
                        boolean isSquare = true;
                        for (int ii = i, iiLen = i + l; ii < iiLen; ii++) {
                            for (int jj = j, jjLen = j + l; jj < jjLen; jj++) {
                                if (matrix[ii][jj] == 0) {
                                    isSquare = false;
                                    ii = iiLen;
                                    break;
                                }
                            }
                        }
                        if (isSquare) answer++;
                    }
                }
            }
        }
        return answer;
    }
}
