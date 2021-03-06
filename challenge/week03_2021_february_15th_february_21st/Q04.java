package challenge.week03_2021_february_15th_february_21st;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3644/
// Arithmetic Slices

import java.util.*;

public class Q04 {
    public int numberOfArithmeticSlices(int[] nums) {
        int answer = 0;

        int len = nums.length;
        if (len >= 3) {
            List<Integer> cntList = new ArrayList<>();
            int cnt = 1;
            int gap = nums[0] - nums[1];
            for (int i = 2; i < len; i++) {
                int newGap = nums[i - 1] - nums[i];
                if (gap == newGap) cnt++;
                else {
                    if (cnt >= 2) cntList.add(cnt);
                    cnt = 1;
                    gap = newGap;
                }
            }

            cntList.add(cnt);
            for (int c : cntList) {
                for (int i = c; i >= 2; i--) {
                    answer += (c - i) + 1;
                }
            }
        }

        return answer;
    }
}
