package challenge.y2021_week11;

// https://leetcode.com/problems/set-mismatch/
// Set Mismatch
// 참고 : https://leetcode.com/problems/set-mismatch/discuss/105507/Java-O(n)-Time-O(1)-Space

import java.util.*;

public class Q02 {
    public int[] findErrorNums(int[] nums) {
        final int LEN = nums.length;
        int[] answer = new int[2];

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= LEN; i++) {
            set.add(i);
        }
        for (int num : nums) {
            if (!set.remove(num)) {
                answer[0] = num;
            }
        }
        answer[1] = set.toArray(Integer[]::new)[0];

        return answer;
    }
}
