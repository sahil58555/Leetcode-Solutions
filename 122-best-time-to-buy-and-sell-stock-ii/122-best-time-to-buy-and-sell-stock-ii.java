class Solution {
    public int maxProfit(int[] prices) {
        
        int[] next = new int[2];
        int n = prices.length;
        
        for(int idx = n ; idx >= 0 ; idx--) {
            
            int[] curr = new int[2];
            
            for(int haveStock = 0 ; haveStock <= 1 ; haveStock++) {
             
                if(idx == n) {
                
                    curr[haveStock] = 0;
                }
                else {

                    int option1 = next[haveStock]; // skipping
                    int option2 = 0;

                    if(haveStock == 1) {

                        // selling
                        option2 = prices[idx] + next[0];
                    }
                    else {

                        // buying
                        option2 = next[1] - prices[idx];
                    }

                    curr[haveStock] = Math.max(option1,option2);
                }
            }
            
            next = curr;
        }
        
        return next[0];
    }
    
    private int maxProfit(int idx,int[] prices,int haveStock,int[][] dp) {
        
        if(idx == prices.length) {
            
            return 0;
        }
        
        if(dp[idx][haveStock] != -1) {
            
            return dp[idx][haveStock];
        }
        
        int option1 = maxProfit(idx+1,prices,haveStock,dp); // skipping
        int option2 = 0;
        
        if(haveStock == 1) {
            
            // selling
            option2 = prices[idx] + maxProfit(idx+1,prices,0,dp);
        }
        else {
            
            // buying
            option2 = maxProfit(idx+1,prices,1,dp) - prices[idx];
        }
        
        return dp[idx][haveStock] = Math.max(option1,option2);
    }
}