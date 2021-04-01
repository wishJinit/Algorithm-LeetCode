package challenge.y2021_week11;

// https://leetcode.com/problems/distribute-candies/
// Distribute Candies

import java.util.HashSet;
import java.util.Set;

public class Q01 {
    public int distributeCandies(int[] candyType) {
        final int LEN = candyType.length;

        Set<Integer> set = new HashSet<>();
        for (int value : candyType) {
            set.add(value);
        }

        return Math.min(set.size(), LEN / 2);
    }
}
