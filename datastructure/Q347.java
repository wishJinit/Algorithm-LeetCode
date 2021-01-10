package datastructure;

// https://leetcode.com/problems/top-k-frequent-elements/
// Top K Frequent Elements

import java.util.*;

public class Q347 {

    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Map.Entry[] entries = map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .toArray(Map.Entry[]::new);

        int size = map.size();
        for (int i = 0; i < k; i++)
            answer[i] = (int) entries[size - i - 1].getKey();

        return answer;
    }
}
