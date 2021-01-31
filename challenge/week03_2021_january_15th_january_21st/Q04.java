package challenge.week03_2021_january_15th_january_21st;

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3608/
// Max Number of K-Sum Pairs

import java.util.Arrays;

public class Q04 {
    public int maxOperations(int[] nums, int k) {
        int answer = 0;
        Arrays.sort(nums);

        int start = 0, end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < k) start++;
            else if (sum > k) end--;
            else {
                answer++;
                start++;
                end--;
            }
        }

        return answer;
    }
}
