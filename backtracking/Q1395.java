package backtracking;

// https://leetcode.com/problems/count-number-of-teams/
// Count Number of Teams

public class Q1395 {
    public int numTeams(int[] rating) {
        final int LEN = rating.length;
        int answer = 0;
        for (int i = 0; i < LEN - 2; i++) {
            int ii = rating[i];
            for (int j = i + 1; j < LEN - 1; j++) {
                int jj = rating[j];
                if (jj > ii) {
                    for (int k = j + 1; k < LEN; k++) {
                        int kk = rating[k];
                        if (kk > jj) answer++;
                    }
                } else if (jj < ii) {
                    for (int k = j + 1; k < LEN; k++) {
                        int kk = rating[k];
                        if (kk < jj) answer++;
                    }
                }
            }
        }
        return answer;
    }
}
