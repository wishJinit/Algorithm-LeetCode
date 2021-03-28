package challenge.y2021_week11;

// https://leetcode.com/problems/design-hashmap/
// Design HashMap

import java.util.*;

public class Q07 {
    static class MyHashMap {
        private static class Entry {
            int key, value;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final List<Entry> list;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            list = new ArrayList<>();
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            boolean isEdit = false;
            for (Entry e : list) {
                if (e.key == key) {
                    e.value = value;
                    isEdit = true;
                    break;
                }
            }
            if (!isEdit) list.add(new Entry(key, value));
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int answer = -1;
            for (Entry e : list) {
                if (e.key == key) {
                    answer = e.value;
                    break;
                }
            }
            return answer;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            for (int i = 0, size = list.size(); i < size; i++) {
                if (list.get(i).key == key) {
                    list.remove(i);
                    break;
                }
            }
        }
    }
}
