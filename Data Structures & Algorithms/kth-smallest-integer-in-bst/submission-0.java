/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int result = -1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        preOrder(root, k);
        return result;
    }

    public void preOrder(TreeNode root, int k){
        if(root == null)
            return;
        // System.out.println("Root "+root.val+" count "+count);
        preOrder(root.left, k);
        if(result != -1)
            return;
        if(count == k-1){
            result = root.val;
            return;
        }
        // System.out.println("After preorder Root "+root.val+" count "+count);
        count++;
        preOrder(root.right, k);
    }
}
