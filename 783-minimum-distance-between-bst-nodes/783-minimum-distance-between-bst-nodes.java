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
    
    int prev;
    int minDiff;
    
    public int minDiffInBST(TreeNode root) {
        
        prev = -1;
        minDiff = Integer.MAX_VALUE;
        
        inorderTraversal(root);
        
        return minDiff;
    }
    
    private void inorderTraversal(TreeNode root) {
        
        if(root == null) {
            
            return;
        }
        
        inorderTraversal(root.left) ;
        
        if(prev != -1) {
            
            minDiff = Math.min(minDiff, root.val - prev);
        }
        
        prev = root.val;
        inorderTraversal(root.right);
    }
}