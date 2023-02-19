class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root==null)
            return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        boolean flag = false;
        
        while(queue.size()!=0)
        {
            int len = queue.size();
            
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int i=0;i<len;i++)
            {
                TreeNode node = queue.remove();
                list.add(node.val);
                
                if(node.left!=null)
                    queue.add(node.left);
                
                if(node.right!=null)
                    queue.add(node.right);
            }
            
            if(flag)
            {
                flag = false;
                Collections.reverse(list);
            }
            else
                flag = true;
            
            ans.add(list);
        }
        
       return ans; 
    }
}