/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int maxAmountOfWater = 0;
        int length = height.length;
        int leftPointer = 0;
        int rightPointer = length - 1;
        int h = 0;
        int w = 0;

        if (length == 2) return Math.min(height[0],height[1]);
        else {
            while (leftPointer < rightPointer) {
                if (height[leftPointer] <= height[rightPointer]) {
                    h = height[leftPointer];
                    w = rightPointer - leftPointer;
                    leftPointer++;
                } else {
                    h = height[rightPointer];
                    w = rightPointer - leftPointer;
                    rightPointer--;
                }
                
                int tempAmountOfWater =  h * w;
                maxAmountOfWater = maxAmountOfWater < tempAmountOfWater ? tempAmountOfWater : maxAmountOfWater;
            } 
           
        return maxAmountOfWater;
        }
    }
}
// @lc code=end

