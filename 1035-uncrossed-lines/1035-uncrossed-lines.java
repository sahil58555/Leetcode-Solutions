class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        int[] next = new int[nums2.length + 1];
        
        for(int idx1 = nums1.length - 1 ; idx1 >= 0 ; idx1--) {
            
            int[] curr = new int[nums2.length + 1];
            
            for(int idx2 = nums2.length - 1 ; idx2 >= 0 ; idx2--) {
                
                int ans = 0;
        
                if(nums1[idx1] == nums2[idx2]) {

                    ans = 1 + next[idx2 + 1];
                }
                else {

                    int option1 = next[idx2];
                    int option2 = curr[idx2 + 1];

                    ans = Math.max(option1, option2); 
                }

                curr[idx2] = ans;
            }
            
            next = curr;
        }
        
        return next[0];
    }
    
}