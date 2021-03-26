package challenge.y2021_week11;

// https://leetcode.com/problems/missing-number/
// Missing Number
// 참고 : https://leetcode.com/problems/missing-number/discuss/69786/3-different-ideas%3A-XOR-SUM-Binary-Search.-Java-code

import java.util.Arrays;

public class Q03 {
    public int missingNumber(int[] nums) {
        final int LEN = nums.length;

        Arrays.sort(nums);

        int answer = nums[0] == 0 ? LEN : 0;
        for (int i = 1; i < LEN; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                answer = nums[i - 1] + 1;
                break;
            }
        }

        return answer;
    }
}
