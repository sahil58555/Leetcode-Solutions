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
    private int id;
    private Set<String> seen;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        map = new HashMap<>();
        ans = new ArrayList<>();
        seen = new HashSet<>();
        id = 1;
        
        DFS(root);
        
        return ans;
    }
    
    private int DFS(TreeNode root) {
        
        if(root == null) {
            
            return 0;
        }
        
        int left = DFS(root.left);
        int right = DFS(root.right);
        
        String hash = root.val + "," + left + "," + right;
        
        if(map.containsKey(hash)) {
            
            if(!seen.contains(hash)) {
                
                ans.add(root);
                seen.add(hash);
            }
        }
        else {
            
            map.put(hash, id);
            id++;
        }
        
        return map.get(hash);
    }
}