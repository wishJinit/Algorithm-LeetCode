package challenge.week04_2021_february_15th_february_21st;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3649/
// Longest Word in Dictionary through Deleting

import java.util.*;

public class Q01 {
    public String findLongestWord(String s, List<String> dictionary) {
        final int SIZE = dictionary.size();

        Collections.sort(dictionary);
        int minDeleteCnt = 0;
        int minDeleteIdx = -1;
        for (int i = 0; i < SIZE; i++) {
            char[] chars = s.toCharArray();
            char[] dictionaryChars = dictionary.get(i).toCharArray();

            int len = dictionaryChars.length;
            int idx = 0;
            for (char c : chars) {
                if (c == dictionaryChars[idx]) {
                    if (++idx >= len) break;
                }
            }
            if (idx == len && minDeleteCnt < idx) {
                minDeleteCnt = idx;
                minDeleteIdx = i;
            }
        }

        return (minDeleteIdx == -1 ? "" : dictionary.get(minDeleteIdx));
    }
}
