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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return formTree(preorder, 0, 0, preorder.length, map);
    }

    public TreeNode formTree(int[] preorder, int m, int n, int len, Map<Integer, Integer> map){
        if(len <= 0)
            return null;
        int rootval = preorder[m];
        int rootindex = map.get(rootval);
        TreeNode root = new TreeNode(rootval);
        root.left = formTree(preorder, m+1, n, rootindex-n, map);
        root.right = formTree(preorder, m+1+rootindex-n, rootindex+1, len-1- (rootindex-n), map);
        return root;
    }
}
