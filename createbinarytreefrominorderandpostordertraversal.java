import java.util.HashMap;

class Solution {
    private int postIndex;
    private HashMap<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        postIndex = postorder.length - 1;

        // Store inorder values and their indices in a hashmap for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int left, int right) {
        if (left > right) return null;

        // Get the root node from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Get the index of root in inorder
        int index = inorderMap.get(rootVal);

        // Build the right subtree first, then the left subtree
        root.right = buildTreeHelper(postorder, index + 1, right);
        root.left = buildTreeHelper(postorder, left, index - 1);

        return root;
    }
}
