package challenge.week03_2021_january_15th_january_21st;

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3609/
// Longest Palindromic Substring

public class Q05 {
    private int LEN;

    public String longestPalindrome(String s) {
        LEN = s.length();

        String answer = Character.toString(s.charAt(0));
        for (int i = LEN; i >= 2; i--) {
            String result = checkPalindrome(s, i);
            if (result != null) {
                answer = result;
                break;
            }
        }

        return answer;
    }

    private String checkPalindrome(String s, int length) {
        String answer = null;
        for (int i = 0, iLen = LEN - length; i <= iLen; i++) {
            boolean check = true;
            int start = i, end = i + length - 1;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    check = false;
                    break;
                }
                start++;
                end--;
            }

            if (check) {
                answer = s.substring(i, i + length);
                break;
            }
        }
        return answer;
    }
}
