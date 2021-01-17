package array;

// https://leetcode.com/problems/matrix-block-sum/
// Matrix Block Sum
// 참고(DP) : https://leetcode.com/problems/matrix-block-sum/discuss/561884/Java-DP-Solution-Clean-Code-O(m*n)

public class Q1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        final int HEIGHT = mat.length, WIDTH = mat[0].length;
        int[][] answer = new int[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                int sum = 0;
                for (int ii = Math.max(0, i - K), iiLen = Math.min(HEIGHT, i + K + 1); ii < iiLen; ii++) {
                    for (int jj = Math.max(0, j - K), jjLen = Math.min(WIDTH, j + K + 1); jj < jjLen; jj++) {
                        sum += mat[ii][jj];
                    }
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
