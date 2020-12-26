package greedy;

// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
// Partitioning Into Minimum Number Of Deci-Binary Numbers

import java.util.Arrays;

public class Q1689 {
    public int minPartitions(String n) {
        char[] chars = n.toCharArray();
        Arrays.sort(chars);
        return (int) chars[chars.length - 1] - '0';
    }
}
