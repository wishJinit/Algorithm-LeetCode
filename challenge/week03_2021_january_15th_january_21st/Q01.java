package challenge.week03_2021_january_15th_january_21st;

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3605/
// Get Maximum in Generated Array

import java.util.*;

public class Q01 {
    public int getMaximumGenerated(int n) {
        int[] arr = new int[n + 1];
        int max = 0;
        if (n > 0) {
            arr[1] = 1;
            for (int i = 1, len = n / 2; i <= len; i++) {
                arr[i * 2] = arr[i];
                if (i * 2 + 1 <= n) {
                    arr[i * 2 + 1] = arr[i] + arr[i + 1];
                }
            }
            Arrays.sort(arr);
            max = arr[n];
        }
        return max;
    }
}
