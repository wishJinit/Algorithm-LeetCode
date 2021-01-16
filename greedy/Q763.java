package greedy;

// https://leetcode.com/problems/partition-labels/
// Partition Labels

import java.util.*;

public class Q763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> answer = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        char[] arr = S.toCharArray();

        for (int i = 0, len = arr.length; i < len; i++) {
            char c = arr[i];
            if (!set.contains(c)) {
                set.add(c);
                int e = S.lastIndexOf(c);
                for (int j = i + 1; j <= e; j++) {
                    char cc = arr[j];
                    if (!set.contains(cc)) {
                        e = Math.max(e, S.lastIndexOf(cc));
                        set.add(cc);
                    }
                }
                answer.add(e - i + 1);
                i = e;
            }
        }
        return answer;
    }
}
