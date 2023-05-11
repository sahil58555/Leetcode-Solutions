class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        Integer[][] dp = new Integer[nums1.length][nums2.length];
        
        return sol(0, 0, nums1, nums2, dp);
    }
    
    private int sol(int idx1, int idx2, int[] nums1, int[] nums2, Integer[][] dp) {
        
        if(idx1 == nums1.length || idx2 == nums2.length) {
            
            return 0;
        }
        
        if(dp[idx1][idx2] != null) {
            
            return dp[idx1][idx2];
        }
        
        int ans = 0;
        
        if(nums1[idx1] == nums2[idx2]) {
            
            ans = 1 + sol(idx1 + 1, idx2 + 1, nums1, nums2, dp);
        }
        else {
            
            int option1 = sol(idx1 + 1, idx2, nums1, nums2, dp);
            int option2 = sol(idx1, idx2 + 1, nums1, nums2, dp);
            
            ans = Math.max(option1, option2); 
        }
        
        return dp[idx1][idx2] = ans;
    }
}