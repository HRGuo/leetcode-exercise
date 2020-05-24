package org.guo.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {

    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] rowMinIdxs = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            rowMinIdxs[i] = findMinIdx(matrix[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rowMinIdxs.length; i++) {
            int col = rowMinIdxs[i];
            if (isMax(matrix, col, matrix[i][col])) res.add(matrix[i][col]);
        }
        return res;
    }

    private int findMinIdx(int[] nums) {
        int min = nums[0];
        int minIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) minIdx = i;
        }
        return minIdx;
    }

    private boolean isMax(int[][] matrix, int col, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] > target) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new LuckyNumber().luckyNumbers(
                new int[][]{{36376,85652,21002,4510},{68246,64237,42962,9974},{32768,97721,47338,5841},{55103,18179,79062,46542}}
        );
    }
}
