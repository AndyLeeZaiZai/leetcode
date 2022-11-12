/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        // Using math insted of converting Integer to String
        int temp = x;
        int reverseOrderNumber = 0;
        while (temp >= 1 ) {
            reverseOrderNumber = reverseOrderNumber*10 + temp%10;
            temp = temp/10;
        }

        // Only one comparison needed 
        return x >= 0 && reverseOrderNumber == x;
    }
}
// @lc code=end

