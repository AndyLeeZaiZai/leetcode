import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        int right = 0;

        HashMap<Character, Integer> subStringMap = new HashMap<>();

        while (right < s.length()) {
            subStringMap.put(s.charAt(right), subStringMap.getOrDefault(s.charAt(right), 0) + 1);
        
            while (subStringMap.get(s.charAt(right)) > 1) {
                subStringMap.put(s.charAt(left), subStringMap.get(s.charAt(left)) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;  
    }
}
// @lc code=end

