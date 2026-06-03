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
    public int goodNodes(TreeNode root) {
        int[] res = new int[1];
        getGoodNodes(root, res, Integer.MIN_VALUE);
        return res[0];
    }

    public void getGoodNodes(TreeNode root, int[] res, int max){
        if(root == null)
            return;
        if(root.val >= max){
            res[0]++;
            max = root.val;
        }
        if(root.left != null)
            getGoodNodes(root.left, res, max);
        if(root.right != null)
            getGoodNodes(root.right, res, max);
        
    }
}
