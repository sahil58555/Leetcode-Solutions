class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        
        for(int i=0;i<nums.length;i++)
        {
            while(stack.size()>0 && len-i-1>=k-stack.size() && nums[i] < stack.peek())
            {
                stack.pop();
            }
            
            stack.push(nums[i]);
        }
        
        while(stack.size()>k)
            stack.pop();
        
        int[] ans = new int[k];
        
        for(int i=k-1;i>=0;i--)
            ans[i] = stack.pop();
        
        return ans;
        
        
    }
}