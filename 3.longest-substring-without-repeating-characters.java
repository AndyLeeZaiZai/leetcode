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
        int longestLength = 0;
        int currentLength = 0;
        int currentIndex = 0;

        HashMap<Character, Integer> subStringMap = new HashMap<>();

        while (currentIndex <= s.length() - 1) {
            if (!subStringMap.containsKey(s.charAt(currentIndex))) {
                subStringMap.put(s.charAt(currentIndex), currentIndex);
                currentLength++;
                currentIndex++;
                longestLength = Math.max(longestLength, currentLength);
            } else {
                currentIndex = subStringMap.get(s.charAt(currentIndex)) + 1;
                subStringMap.clear();
                currentLength = 0;
            }   
        }

        return longestLength;  
    }
}
// @lc code=end

