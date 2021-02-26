package challenge.week02_2021_february_8th_february_14th;

// https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3636/
// Valid Anagram

import java.util.Arrays;

public class Q04 {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return new String(sArr).equals(new String(tArr));
    }
}
