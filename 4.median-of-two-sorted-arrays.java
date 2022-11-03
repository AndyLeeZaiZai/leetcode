/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthNums1 = nums1.length;
        int lengthNums2 = nums2.length;
        int totalLength = lengthNums1 + lengthNums2;

        if (lengthNums1 > lengthNums2) return findMedianSortedArrays(nums2, nums1);

        if (lengthNums1 == 0) {
            if (lengthNums2%2 == 0) return nums2[(lengthNums2/2 - 1)] * 0.5 + nums2[(lengthNums2/2)] * 0.5;
            else return (double) nums2[(lengthNums2-1)/2];
        } 

        if (lengthNums2 == 0) {
            if (lengthNums1%2 == 0) return nums1[(lengthNums1/2 - 1)] * 0.5 + nums1[(lengthNums1/2)] * 0.5;
            else return (double) nums1[(lengthNums1-1)/2];
        } 

        int left = 0;
        int right = lengthNums1;
        while (left < right) {
            int mid = (left + right)/2;
            int index = (totalLength)/2 - mid;
            if (nums1[mid] < nums2[index - 1])  left = mid + 1;
            else right = mid;
        }
        
        int indexInNums2 = (totalLength)/2 - left;
        int nums1Left = left == 0 ? Integer.MIN_VALUE : nums1[left - 1];
        int nums1Right = left == lengthNums1 ? Integer.MAX_VALUE : nums1[left];
        int nums2Left = indexInNums2 == 0 ? Integer.MIN_VALUE : nums2[indexInNums2 - 1];
        int nums2Right = indexInNums2 == lengthNums2 ? Integer.MAX_VALUE : nums2[indexInNums2];

        if (totalLength%2 == 0) return Math.max(nums1Left, nums2Left) * 0.5 + Math.min(nums1Right, nums2Right) * 0.5;
        else return (double) Math.min(nums1Right, nums2Right);

    }
}
// @lc code=end

