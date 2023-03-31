class Solution {
    
    private int[][] prefix;
    private Long[][][] dp;
    private int bottom;
    private int right;
    
    public int ways(String[] pizza, int k) {
        
        int n = pizza.length;
        int m = pizza[0].length();
        
        bottom = n - 1;
        right = m - 1;
        
        prefix = new int[n][m];
        dp = new Long[n][m][k + 1];
        
        for(int i = 0 ; i < n ; i++) {
            
            for(int j = 0 ; j < m ; j++) {
                
                int sum = pizza[i].charAt(j) == 'A' ? 1 : 0;
                
                if(i > 0)
                sum += prefix[i - 1][j];

                if(j > 0)
                sum += prefix[i][j - 1];

                if(i > 0 && j > 0)
                sum -= prefix[i - 1][j - 1];
                
                prefix[i][j] = sum;
            }
        }

        return (int)countWays(0, 0, k - 1);
    }
    
    private long countWays(int top, int left, int k) {
        
        if(k == 0) {
            
            return 1;
        }
        
        if(dp[top][left][k] != null) {
            
            return dp[top][left][k];
        }
        
        long count = 0;
        int mod = 1000000000 + 7;
        
        
        for(int row = top ; row < bottom ; row++) {
            
            if(prefixSum(top, row, left, right) > 0 && prefixSum(row + 1, bottom, left, right) > 0) {
                
                count = (count + countWays(row + 1, left, k - 1)) % mod;
            }
        }
        
        for(int col = left ; col < right ; col++) {
            
            if(prefixSum(top, bottom, left, col) > 0 && prefixSum(top, bottom, col + 1, right) > 0) {
                
                count = (count + countWays(top, col + 1, k - 1)) % mod;
            }
        }
        
        return dp[top][left][k] = count;
    }
    
    private int prefixSum(int top, int bottom, int left, int right) {
        
        int sum = prefix[bottom][right];
        
        if(top > 0)
        sum -= prefix[top - 1][right];
        
        if(left > 0)
        sum -= prefix[bottom][left - 1];
        
        if(top > 0 && left > 0)
        sum += prefix[top - 1][left - 1];
        
        return sum;
    }
}