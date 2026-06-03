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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        getDiameter(root, res); 
        return res[0];
    }

    public int getDiameter(TreeNode root, int[] res){
        if(root == null)
            return 0;
        int left = getDiameter(root.left, res);
        int right = getDiameter(root.right,res);
        res[0] = Math.max(res[0], left+right);
        return 1+ Math.max(left, right);
    }

    // public int getHeight(TreeNode root){
    //     if(root == null)
    //         return 0;
    //     return Math.max(getHeight(root.left), getHeight(root.right))+1;
    // }
}
