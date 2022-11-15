class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        
        for(int i = 0 ; i < n ; i++) {
            
            if(nums[i] <= 0 || nums[i] > n)
                nums[i] = n + 2;
        }
        
        System.out.println(Arrays.toString(nums));
        
        for(int i = 0 ; i < n ; i++) {
            
            int num = Math.abs(nums[i]);
            
            if(num == n + 2) continue;
            
            int mappingIdx = num - 1;
            
            if(nums[mappingIdx] > 0) nums[mappingIdx] = -1 * nums[mappingIdx];
        }
        
        int ans = n + 1;
        
        for(int i = 0 ; i < n ; i++) {
            
            if(nums[i] > 0) {
                
                ans = i + 1;
                break;
            }
        }
        
        return ans;
    }
}