class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;  // Base case
        if (node.val <= min || node.val >= max) return false;  // Violates BST condition
        
        // Recursively check left and right subtrees with updated ranges
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
