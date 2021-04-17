package challenge.y2021_week15;

// https://leetcode.com/problems/word-subsets/
// Word Subsets
// Map 사용

import java.util.*;

public class Q05_1 {

    public List<String> wordSubsets(String[] A, String[] B) {
        final int ALPHA_LEN = 26;

        Map<Character, Integer> map = new HashMap<>();
        for (String b : B) {
            int[] alpha = new int[ALPHA_LEN];
            for (char cb : b.toCharArray()) {
                alpha[cb - 'a']++;
            }
            for (char cb : b.toCharArray()) {
                if (map.containsKey(cb)) map.put(cb, Math.max(map.get(cb), alpha[cb - 'a']));
                else map.put(cb, alpha[cb - 'a']);
            }
        }

        List<String> answer = new ArrayList<>();
        for (String a : A) {
            if (checkStr(a, map)) answer.add(a);
        }

        return answer;
    }

    private boolean checkStr(String s, Map<Character, Integer> charMap) {
        int cnt = 0;
        Map<Character, Integer> map = new HashMap<>(charMap);
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) cnt++;
            }
        }
        return map.size() <= cnt;
    }
}
