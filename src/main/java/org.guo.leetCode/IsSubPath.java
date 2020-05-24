package org.guo.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IsSubPath {

    public boolean isSubPath(ListNode head, TreeNode root) {
        List<TreeNode> candidates = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.pop();
            if (treeNode.val == head.val) {
                candidates.add(treeNode);
            }
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }

        for (TreeNode candidate : candidates) {
            if(found(candidate, head)) {
                return true;
            }
        }
        return false;
    }

    public boolean found(TreeNode treeNode, ListNode p) {
        if (treeNode.val != p.val) {
            return false;
        } else {
            if (p.next == null) {
                return true;
            }
            if(treeNode.left == null && treeNode.right == null) {
                return false;
            } else if(treeNode.left == null){
                return found(treeNode.right, p.next);
            } else if(treeNode.right == null) {
                return found(treeNode.left, p.next);
            } else {
                return found(treeNode.left, p.next) || found(treeNode.right, p.next);
            }
        }
    }
}
