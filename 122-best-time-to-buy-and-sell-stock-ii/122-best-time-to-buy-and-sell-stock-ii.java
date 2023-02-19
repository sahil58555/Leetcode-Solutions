class Solution {
    public int maxProfit(int[] prices) {
        
        int[][] dp = new int[prices.length + 1][2];
        int n = prices.length;
        
        for(int idx = n ; idx >= 0 ; idx--) {
            
            for(int haveStock = 0 ; haveStock <= 1 ; haveStock++) {
             
                if(idx == n) {
                
                    dp[idx][haveStock] = 0;
                }
                else {

                    int option1 = dp[idx+1][haveStock]; // skipping
                    int option2 = 0;

                    if(haveStock == 1) {

                        // selling
                        option2 = prices[idx] + dp[idx+1][0];
                    }
                    else {

                        // buying
                        option2 = dp[idx+1][1] - prices[idx];
                    }

                    dp[idx][haveStock] = Math.max(option1,option2);
                }
            }
        }
        
        return dp[0][0];
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