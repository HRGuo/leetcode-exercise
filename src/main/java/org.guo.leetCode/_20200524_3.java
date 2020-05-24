package org.guo.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _20200524_3 {

    List<List<Integer>> list = new ArrayList<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, new ArrayList<>());
        int res = 0;
        for (List<Integer> uncheck : list) {
            if (reverse(uncheck)) {
                res++;
            }
        }
        return res;
    }

    private void dfs(TreeNode root, List<Integer> tmpList) {
        if (null == root) {
            return;
        }
        List<Integer> newList = new ArrayList<>();
        newList.addAll(tmpList);
        newList.add(root.val);
        if (null == root.left && null == root.right) {
            list.add(newList);
        } else {
            dfs(root.left, newList);
            dfs(root.right, newList);
        }
    }

    private boolean reverse(List<Integer> toBeCheck) {
        if (toBeCheck.size() % 2 == 0) {
            int tmp =  toBeCheck.get(0);
            for (int i = 1; i < toBeCheck.size(); i++) {
                tmp ^= toBeCheck.get(i);
            }
            return tmp == 0;
        } else {
            Collections.sort(toBeCheck);
            for (int i = 0; i < toBeCheck.size() - 1; i += 2) {
                if (toBeCheck.get(i) != toBeCheck.get(i+1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
