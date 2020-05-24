package org.guo.leetCode;

import java.util.HashSet;
import java.util.Set;

public class ValidBinaryTree {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> set = new HashSet<>();
        boolean end = false;
        int next = 0;
        for(int layer = 0; layer < n; layer++) {
            int layerNum = Math.min(next + (int)Math.pow(2, layer), n);
            boolean isEnd = true;
            for (int i = next; i < layerNum ; i++) {
                if (leftChild[i] != -1) {
                    if(end) {
                        return false;
                    }
                    if (set.contains(leftChild[i])) {
                        return false;
                    } else {
                        set.add(leftChild[i]);
                    }
                    isEnd = false;
                }
                if (rightChild[i] != -1) {
                    if(end) {
                        return false;
                    }
                    if (set.contains(rightChild[i])) {
                        return false;
                    } else {
                        set.add(rightChild[i]);
                    }
                    isEnd = false;
                }
                next++;
            }
            if (isEnd) {
                end = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new ValidBinaryTree().validateBinaryTreeNodes(6, new int[]{1,-1,-1,4,-1,-1},
                new int[]{2,-1,-1,5,-1,-1});
    }
}
