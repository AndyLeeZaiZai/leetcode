import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.00;
        List<Integer> mergedList = new ArrayList<Integer>();

        if(nums1.length != 0) {
            mergedList = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            if(nums2.length != 0) mergedList.addAll(0, Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        }
        else {
            mergedList = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        }

        Collections.sort(mergedList);

        int length = mergedList.size();

        if (length == 1) {
            result = mergedList.get(0);
        } else if (length%2==0) {
            result = (mergedList.get(length/2 - 1) + mergedList.get((length+2)/2 - 1)) / 2.0;
        } else {
            result = mergedList.get((length-1)/2);
        }
        
        return result;
    }
}
// @lc code=end

