package org.guo.leetCode;

public class SearchMatrixII {

        public boolean searchMatrix(int[][] matrix, int target) {
            for (int i = 0; i < matrix.length; i++) {
                if (binarySearch(matrix[i], target)){
                    return true;
                }
            }
            return false;
        }

        private boolean binarySearch(int[] array, int target) {
            int left = 0, right = array.length - 1;
            while (right >= left) {
                int mid = (left + right) / 2;
                if (array[mid] > target) {
                    right = mid - 1;
                } else if (array[mid] < target){
                    left = mid + 1;
                } else {
                    return true;
                }
            }
            return false;
        }

    public static void main(String[] args) {
        System.out.println(new SearchMatrixII().searchMatrix(
                new int[][]{{1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24},
                        {18,21,23,26,30}},
        20));
    }
}
