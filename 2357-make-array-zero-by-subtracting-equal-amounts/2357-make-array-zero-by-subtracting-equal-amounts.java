class Solution {
    public int minimumOperations(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        int idx = 0;
        
        Arrays.sort(nums);
        int sum = 0;
        
        while(idx < n) {
            
            while(idx < n && nums[idx] - sum == 0) idx++;
            
            if(idx == n) break;
            
            ans++;
            
            sum += (nums[idx] - sum);
        }
        
        return ans;
    }
}