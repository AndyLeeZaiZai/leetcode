import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        // Using math insted of converting Integer to String
        // Handle special cases
        if (x < 0) return false;
        if (x >= 0 && x <= 9) return true;

        // Save the result of mod caculation and remove the units digits by divive the numnber by 10
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int temp = x;
        while (temp >= 1) {
            map.put(i, temp%10);
            temp = temp/10;
            i++;
        }

        // Reconstruct the number in a reverse order and comapre if it is the same as the original one
        int factor = 1;
        int reverseOrderNumber = 0;
        for(int j = map.size() - 1; j >= 0; j--) {
            reverseOrderNumber = reverseOrderNumber + map.get(j) * factor;
            factor = factor * 10;
        }

        // Only one comparison needed 
        return reverseOrderNumber == x;
    }
}
// @lc code=end

