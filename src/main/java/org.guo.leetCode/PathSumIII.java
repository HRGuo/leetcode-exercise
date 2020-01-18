package org.guo.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }
        int way = fixedNodePathSum(root, sum);
        if (root.left != null) {
            way += pathSum(root.left, sum);
        }
        if (root.right != null) {
            way += pathSum(root.right, sum);
        }
        return way;
    }

    public int fixedNodePathSum(TreeNode node, int sum) {
        if (null == node) {
            return 0;
        }
        if (node.val == sum) {
            return 1;
        } else {
            return fixedNodePathSum(node.left, sum - node.val) + fixedNodePathSum(node.right, sum - node.val);
        }
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int sum = Integer.parseInt(line);

            int ret = new PathSumIII().pathSum(root, sum);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }


}
