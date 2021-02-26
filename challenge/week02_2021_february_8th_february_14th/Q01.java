package challenge.week02_2021_february_8th_february_14th;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3633/
// Peeking Iterator

import java.util.*;

public class Q01 {
    static class PeekingIterator implements Iterator<Integer> {
        private final List<Integer> list = new ArrayList<>();
        private int size = 0;
        private int idx = 0;

        public PeekingIterator(Iterator<Integer> iterator) {
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
            size = list.size();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return list.get(idx);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return list.get(idx++);
        }

        @Override
        public boolean hasNext() {
            return idx < size;
        }
    }
}
