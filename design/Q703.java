package design;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
// Kth Largest Element in a Stream

import java.util.*;

public class Q703 {
    static class KthLargest {
        int k;
        List<Integer> list;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            list = new ArrayList<>();
            for (int num : nums) list.add(num);
        }

        public int add(int val) {
            list.add(val);
            Collections.sort(list);
            return list.get(list.size() - k);
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        sb.append(kthLargest.add(3)).append("\n");
        sb.append(kthLargest.add(5)).append("\n");
        sb.append(kthLargest.add(10)).append("\n");
        sb.append(kthLargest.add(9)).append("\n");
        sb.append(kthLargest.add(4)).append("\n");
        System.out.println(sb.toString());
    }
}
