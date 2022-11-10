/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        // Top-down dynamic programming, using memorization
        boolean dp[][] = new boolean[length][length] ;        
        int max = 0;
        int start = 0;
        int end = 0;

        // If String Sm...Sn is palindrome, then String Sm-1...Sn-1 must be a palindrome: it means if Sm-1...Sn-1 is a palindrome,
        // and Sm == Sn, then Sm...Sn must be a palindrome
        // For each problem dp[i][j], dp[i+1][j-1] has been caculated once and saved in the multidimensional array
        for (int right = 0; right < length; right++) {
            for (int left = 0; left <= right; left++) {
                // left, right: 00
                // left, right: 10, 11
                // left, right: 20, 21, 22
                // left, right: ..........
                Boolean comparison = s.charAt(left) == s.charAt(right);
                // when s.lenth() is is [1,2,3], only compare the start and the end to determine if it is a palindrome
                dp[left][right] = (right - left > 2) ?  comparison && dp[left + 1][right - 1] : comparison;
                if (dp[left][right] && max < right - left + 1) {
                    max = right - left + 1;
                    start = left;
                    end = right;
                }
            }
        }

        // endIndex + 1 otherwise it will not be included in the substring, it is how this substring method implemented
        return s.substring(start, end + 1);
        
    }
}
// @lc code=end

