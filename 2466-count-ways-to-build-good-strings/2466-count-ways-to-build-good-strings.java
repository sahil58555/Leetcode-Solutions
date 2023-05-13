class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        long[] dp = new long[high + 1];
        Arrays.fill(dp, -1);
        
        return (int)sol(1, low, high, zero, one, dp);
    }
    
    private long sol(int idx, int low, int high, int zero, int one, long[] dp) {
         
        if(idx > high) {
            
            return (idx - 1 == high) ? 1 : 0;
        }
        
        if(dp[idx] != -1) return dp[idx];
        int mod = 1000000000 + 7;
        
        long op1 = sol(idx + zero, low, high, zero, one, dp);
        long op2 = sol(idx + one, low, high, zero, one, dp);
        
        long ans = (op1 + op2) % mod + ((idx > low) ? 1 : 0);
        
        return dp[idx] = ans;
    }
}