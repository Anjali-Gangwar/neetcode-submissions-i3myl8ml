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

    int preIdx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode build(int[] preorder, int start, int end){

        if(start > end){
            return null;
        }

        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        int idx = map.get(rootVal);

        root.left = build(preorder, start, idx-1);
        root.right = build(preorder, idx+1, end);

        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }
}
