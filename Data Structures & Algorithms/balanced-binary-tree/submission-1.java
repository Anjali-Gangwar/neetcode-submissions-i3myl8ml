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

    int maxHtDiff = 0;

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHt = height(root.left);
        int rightHt = height(root.right);

        maxHtDiff = Math.max(maxHtDiff, Math.abs(leftHt - rightHt));

        return Math.max(leftHt, rightHt) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        height(root);

        if(maxHtDiff > 1){
            return false;
        }

        return true;
    }
}
