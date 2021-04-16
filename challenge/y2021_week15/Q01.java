package challenge.y2021_week15;

// https://leetcode.com/problems/vowel-spellchecker/
// Vowel Spellchecker

import java.util.*;

public class Q01 {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        final int LEN = queries.length;
        String[] answer = new String[LEN];

        Map<String, List<String>> wordMap = new HashMap<>();
        for (String word : wordlist) {
            String key = conversionVowel(word);
            if (!wordMap.containsKey(key)) {
                wordMap.putIfAbsent(key, new ArrayList<>() {{
                    add(word);
                }});
            } else {
                wordMap.get(key).add(word);
            }
        }

        for (int i = 0; i < LEN; i++) {
            List<String> list = wordMap.get(conversionVowel(queries[i]));
            if (list == null) answer[i] = "";
            else {
                String query = queries[i];
                int idx = 0;
                boolean checkSpelling = false;
                for (int j = 0, size = list.size(); j < size; j++) {
                    if (checkSameString(query, list.get(j))) {
                        idx = j;
                        break;
                    } else if (!checkSpelling && checkSameSpelling(query, list.get(j))) {
                        idx = j;
                        checkSpelling = true;
                    }
                }
                answer[i] = list.get(idx);
            }
        }

        return answer;
    }

    private boolean checkVowel(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u';
    }

    private String conversionVowel(String s) {
        final int LEN = s.length();

        StringBuilder sb = new StringBuilder();
        sb.append(LEN);

        for (int i = 0; i < LEN; i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (checkVowel(c)) {
                sb.append(i).append(c);
            }
        }

        return sb.toString();
    }

    private boolean checkSameString(String s1, String s2) {
        return s1.equals(s2);
    }

    private boolean checkSameSpelling(String s1, String s2) {
        return s1.toLowerCase().equals(s2.toLowerCase());
    }
}
