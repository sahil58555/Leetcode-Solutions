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
    public int getMinimumDifference(TreeNode root) {
     
        return morrisTraversal(root);
    }
    
    private int morrisTraversal(TreeNode root) {
        
        TreeNode curr = root;
        int minDiff = Integer.MAX_VALUE;
        TreeNode prev = null;
        
        while(curr != null) {
            
            TreeNode left = curr.left;
            
            if(left == null) {
                
                if(prev != null) {
                    
                    minDiff = Math.min(minDiff, curr.val - prev.val); 
                }
                
                prev = curr;
                curr = curr.right;
            }
            else {
                
                TreeNode rightMostNode = getRightMostNode(left, curr);
                
                if(rightMostNode.right == null) {
                    
                    rightMostNode.right = curr;
                    curr = curr.left;
                }
                else {
                    
                    rightMostNode.right = null;
                    
                    if(prev != null) {
                    
                        minDiff = Math.min(minDiff, curr.val - prev.val); 
                    }
                    
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        
        return minDiff;
    }
    
    private TreeNode getRightMostNode(TreeNode node, TreeNode root) {
        
        while(node.right != null && node.right != root) {
            
            node = node.right;
        }
        
        return node;
    }
}