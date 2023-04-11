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
    
    private Map<TreeNode, Integer> height;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        height = new HashMap<>();
        
        buildHeightMap(root);
        height.put(null, 0);
        
        return subtreeWithAllDeepest_(root);
    }
    
    private TreeNode subtreeWithAllDeepest_(TreeNode root) {
        
        int leftHeight = height.get(root.left);
        int rightHeight = height.get(root.right);
        
        if(leftHeight > rightHeight) {
            
            return subtreeWithAllDeepest_(root.left);
        }
        else if(leftHeight < rightHeight) {
            
            return subtreeWithAllDeepest_(root.right);
        }
        
        return root;
    }
    
    private int buildHeightMap(TreeNode root) {
        
        if(root == null) {
            
            return 0;
        }
        
        int left = buildHeightMap(root.left);
        int right = buildHeightMap(root.right);
        
        height.put(root, Math.max(left, right) + 1);
        
        return height.get(root);
    }
}