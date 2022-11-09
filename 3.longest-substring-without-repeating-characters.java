import java.util.HashMap;

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
            if (subStringMap.containsKey(s.charAt(right))) {
                left = Math.max(subStringMap.get(s.charAt(right)), left) ;
            }

            subStringMap.put(s.charAt(right), right + 1);
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;  
    }
}
// @lc code=end

