package challenge.y2021_week13;

// https://leetcode.com/problems/remove-palindromic-subsequences/
// Remove Palindromic Subsequences

public class Q01 {
    public int removePalindromeSub(String s) {
        return s.equals(new StringBuilder(s).reverse().toString()) ? 1 : 2;
    }
}