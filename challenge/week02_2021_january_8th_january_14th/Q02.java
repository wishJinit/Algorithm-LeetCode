package challenge.week02_2021_january_8th_january_14th;

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3600/
// Merge Sorted Array

import java.util.Arrays;

public class Q02 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0, len = m + n; i < len; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }
}
