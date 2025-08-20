package BinarySearchTree;

import java.util.*;

public class Maximum_Width_of_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Pair {
        TreeNode node;
        long idx;
        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(root, 0L));
            int maxWidth = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                long min = q.peek().idx; // baseline for this level
                long first = 0, last = 0;

                for (int i = 0; i < size; i++) {
                    Pair cur = q.poll();
                    long curIdx = cur.idx - min; // normalize to avoid overflow
                    if (i == 0) first = curIdx;
                    if (i == size - 1) last = curIdx;

                    if (cur.node.left != null) {
                        q.add(new Pair(cur.node.left, 2 * curIdx + 1));
                    }
                    if (cur.node.right != null) {
                        q.add(new Pair(cur.node.right, 2 * curIdx + 2));
                    }
                }
                maxWidth = Math.max(maxWidth, (int)(last - first + 1));
            }
            return maxWidth;
        }
    }
}
