package challenge.week04_2021_february_15th_february_21st;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3650/
// Search a 2D Matrix II

public class Q02 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean answer = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (target < value) {
                    break;
                } else if (value == target) {
                    answer = true;
                    i = m;
                    break;
                }
            }
        }
        return answer;
    }
}
