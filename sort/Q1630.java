package sort;

// https://leetcode.com/problems/arithmetic-subarrays/
// Arithmetic Subarrays

import java.util.*;

public class Q1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        final int LEN = l.length;
        List<Boolean> answer = new ArrayList<>();

        for (int i = 0; i < LEN; i++) {
            int ll = l[i], rr = r[i];
            int[] partOfArray = Arrays.copyOfRange(nums, ll, rr + 1);
            Arrays.sort(partOfArray);
            int gap = partOfArray[0] - partOfArray[1];
            boolean check = true;

            for (int j = 1, len = partOfArray.length - 1; j < len; j++) {
                if (partOfArray[j] - partOfArray[j + 1] != gap) {
                    check = false;
                    break;
                }
            }

            answer.add(check);
        }

        return answer;
    }
}
