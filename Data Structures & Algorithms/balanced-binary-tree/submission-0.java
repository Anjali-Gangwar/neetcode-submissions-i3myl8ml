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

    public boolean isBalanced(TreeNode root) {
        
        return height(root) != -1;
        
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHt = height(root.left);

        if(leftHt == -1){
            return -1;
        }

        int rightHt = height(root.right);

        if(rightHt == -1){
            return -1;
        }

        int diff = Math.abs(leftHt - rightHt);

        if(diff > 1){
            return -1;
        }

        return Math.max(leftHt, rightHt) + 1;
    }
}
