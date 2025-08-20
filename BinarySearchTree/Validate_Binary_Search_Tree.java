package BinarySearchTree;

public class Validate_Binary_Search_Tree {

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

    class Solution {

        public boolean isValidBST(TreeNode root) {
            BstPair result = validateBST(root);
            return result.isbst;
        }

        public BstPair validateBST(TreeNode root) {
            if (root == null) {
                return new BstPair(); // Base case: An empty tree is a BST
            }

            BstPair lbp = validateBST(root.left);
            BstPair rbp = validateBST(root.right);

            BstPair sbp = new BstPair();
            sbp.min = Math.min(root.val, Math.min(lbp.min, rbp.min));
            sbp.max = Math.max(root.val, Math.max(lbp.max, rbp.max));

            // Check BST validity
            sbp.isbst = lbp.isbst && rbp.isbst && lbp.max < root.val && rbp.min > root.val;

            return sbp;
        }

        class BstPair {
            boolean isbst = true;
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
        }
    }
}




		// cleaner solution
//public boolean isValidBST(TreeNode root) {
//    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
//}
//
//private boolean isValid(TreeNode node, long min, long max) {
//    if (node == null) return true;
//    if (node.val <= min || node.val >= max) return false;
//    return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
//}

