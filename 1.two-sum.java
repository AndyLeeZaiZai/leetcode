import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map =  new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int numTwo = target - nums[i];
            if (map.containsKey(numTwo)) {
                return new int[] {map.get(numTwo), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
// @lc code=end

