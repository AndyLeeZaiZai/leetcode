/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1 || len <= numRows) return s;

        int gapFirstAndLastRow = (numRows - 2) * 2 + 2;
        int gapTopDown = gapFirstAndLastRow - 2;
        int gapBottomUp = 2;
        StringBuilder res = new StringBuilder();

        for (int row = 1; row <= numRows; row++) {
            int startIndexEachRow = row - 1;
            if (row == 1) {
                while (startIndexEachRow < len) {
                    res.append(s.charAt(startIndexEachRow));
                    startIndexEachRow = startIndexEachRow + gapFirstAndLastRow;
                }
            } else if (row == numRows) {
                while (startIndexEachRow < len) {
                    res.append(s.charAt(startIndexEachRow));
                    startIndexEachRow = startIndexEachRow + gapFirstAndLastRow;
                }
            } else {
                int flag = 0;
                while (startIndexEachRow < len) {
                    int currentIndex = startIndexEachRow;
                    res.append(s.charAt(currentIndex));
                    startIndexEachRow = (flag%2 == 0) ? startIndexEachRow + gapTopDown : startIndexEachRow + gapBottomUp;
                    flag++;
                }
                gapTopDown -= 2;
                gapBottomUp += 2;
            }



        }

        return res.toString();
    }
}
// @lc code=end

