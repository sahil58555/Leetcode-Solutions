class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        Integer[][] dp = new Integer[nums1.length][nums2.length + 1];
        
        return sol(0, 0, nums1, nums2, dp);
    }
    
    private int sol(int idx, int maxIdx, int[] nums1, int[] nums2, Integer[][] dp) {
        
        if(idx == nums1.length) {
            
            return 0;
        }
        
        if(dp[idx][maxIdx] != null) {
            
            return dp[idx][maxIdx];
        }
        
        int notTake = sol(idx + 1, maxIdx, nums1, nums2, dp);
        int take = 0;
        
        for(int i = maxIdx ; i < nums2.length ; i++) {
            
            if(nums2[i] == nums1[idx]) {
                
                take = 1 + sol(idx + 1, i + 1, nums1, nums2, dp);
                break;
            }
        }
        
        return dp[idx][maxIdx] = Math.max(notTake, take);
    }
}