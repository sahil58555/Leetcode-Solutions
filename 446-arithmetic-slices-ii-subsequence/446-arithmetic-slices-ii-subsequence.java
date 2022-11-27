class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int count = 0;
        
        HashMap<Long,Integer>[] dp = new HashMap[nums.length];
        
        for(int i=0;i<nums.length;i++)
        {
            HashMap<Long,Integer> map = new HashMap<>();
            
            for(int j=0;j<i;j++)
            {
                long diff = 0l + nums[i] - nums[j];
                int prevFreq = dp[j].getOrDefault(diff,0);
                int currFreq = map.getOrDefault(diff,0);
                
                count+=prevFreq;
                map.put(diff,prevFreq+currFreq+1);
                
            }
            
            dp[i] = map;
        }
        
        return count;
    }
}