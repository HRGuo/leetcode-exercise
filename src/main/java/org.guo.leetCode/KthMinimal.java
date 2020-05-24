package org.guo.leetCode;

public class KthMinimal {

    public int kthSmallest(int[][] matrix, int k) {
        int[] pos = new int[k];
        if (k == 1) {
            return matrix[0][0];
        }
        if (k == matrix.length * matrix.length) {
            return matrix[k-1][k-1];
        }
        int cur = matrix[0][0];
        int line = 0;
        pos[0] = 1;
        for (int i = 1; i < k; i++) {
            int next = Integer.MAX_VALUE;
            int nextLine = -1;
            for (int j = 0; j < Math.min(line+2, matrix.length); j++) {
                if (pos[j] < matrix.length && matrix[j][pos[j]] < next) {
                    next = matrix[j][pos[j]];
                    nextLine = j;
                }
            }
            pos[nextLine]++;
            line = nextLine;
            cur = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new KthMinimal().kthSmallest(new int[][]{{ 1,  5,  9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }
}
