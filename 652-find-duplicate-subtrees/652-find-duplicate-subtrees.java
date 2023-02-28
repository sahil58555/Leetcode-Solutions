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
    
    private Map<String, Integer> map;
    private List<TreeNode> ans;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        map = new HashMap<>();
        ans = new ArrayList<>();
        
        DFS(root);
        
        return ans;
    }
    
    private String DFS(TreeNode root) {
        
        if(root == null) {
            
            return ".";
        }
        
        String left = DFS(root.left);
        String right = DFS(root.right);
        
        String hash = root.val + "L" + left + "R" + right;
        map.put(hash, map.getOrDefault(hash, 0) + 1);
        
        if(map.get(hash) == 2) {
            
            ans.add(root);
        }
        
        return hash;
    }
}