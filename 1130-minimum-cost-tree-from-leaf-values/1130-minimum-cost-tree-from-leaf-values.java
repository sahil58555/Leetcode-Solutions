class Solution {
    
    private int[][] max;
    
    public int mctFromLeafValues(int[] arr) {
     
        int n = arr.length;
        preComputeMaxValueInAllSubArrays(arr);
        
        Integer[][] dp = new Integer[n][n];
        
        return solve(arr, 0, n - 1, dp);
    }
    
    private int solve(int[] arr, int left, int right, Integer[][] dp) {
        
        if(left == right) {
            
            return 0;
        }
        
        if(dp[left][right] != null) {
            
            return dp[left][right];
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = left ; i < right ; i++) {
            
            int sum = max[left][i] * max[i + 1][right] + solve(arr, left, i, dp) + solve(arr, i + 1, right, dp);
            ans = Math.min(ans, sum);
        }
        
        return dp[left][right] = ans;
    }
    
    private void preComputeMaxValueInAllSubArrays(int[] arr) {
        
        int n = arr.length; 
        max = new int[n][n];
        
        for(int i = 0 ; i < n ; i++) {
            
            int maxEle = 0;
            
            for(int j = i ; j < n ; j++) {
                
                maxEle = Math.max(maxEle, arr[j]);
                max[i][j] = maxEle;
            }
        }
    }
}