class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        
        for(int idx1 = nums1.length - 1 ; idx1 >= 0 ; idx1--) {
            
            for(int idx2 = nums2.length - 1 ; idx2 >= 0 ; idx2--) {
                
                int ans = 0;
        
                if(nums1[idx1] == nums2[idx2]) {

                    ans = 1 + dp[idx1 + 1][idx2 + 1];
                }
                else {

                    int option1 = dp[idx1 + 1][idx2];
                    int option2 = dp[idx1][idx2 + 1];

                    ans = Math.max(option1, option2); 
                }

                dp[idx1][idx2] = ans;
            }
        }
        
        return dp[0][0];
    }
    
}