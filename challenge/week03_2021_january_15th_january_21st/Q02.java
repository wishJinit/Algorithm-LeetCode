package challenge.week03_2021_january_15th_january_21st;

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3606/
// Kth Largest Element in an Array

import java.util.*;

public class Q02 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
