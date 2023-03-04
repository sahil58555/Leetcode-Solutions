class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        long ans = 0;
        int min = 0;
        int max = 0;
        int n = nums.length;
        int breakPoint = nextBreakPoint(0, nums, minK, maxK);
        
        for(int i = 0 ; i < n ; i++) {
            
            if(i == breakPoint) {
                
                breakPoint = nextBreakPoint(breakPoint + 1, nums, minK, maxK);
                continue;
            }
            
            min = indexOf(nums, Math.max(min, i), minK);
            max = indexOf(nums, Math.max(max, i), maxK);
            
            if(Math.max(min, max) < breakPoint) {
                
                ans += breakPoint - Math.max(min, max);
            }
        }
        
        return ans;
    }
    
    private int nextBreakPoint(int startIdx, int[] nums, int minK, int maxK) {
        
        while(startIdx < nums.length) {
            
            if(nums[startIdx] < minK || nums[startIdx] > maxK) {
                
                return startIdx;
            }
            
            startIdx++;
        }
        
        return nums.length;
    }
    
    private int indexOf(int[] nums, int start, int target) {
        
        while(start < nums.length && nums[start] != target) {
            
            start++;
        }
        
        return start;
    }
}