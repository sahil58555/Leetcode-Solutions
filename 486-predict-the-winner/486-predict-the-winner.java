class Solution {
    public boolean PredictTheWinner(int[] nums) {
     
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        
        int scoreOfPlayer1 = findOptimalScore(0, n - 1, nums, dp);
        int scoreOfPlayer2 = Arrays.stream(nums).sum() - scoreOfPlayer1;
        
        boolean canPlayer1Wins = (scoreOfPlayer1 >= scoreOfPlayer2);
        
        return canPlayer1Wins;
    }
    
    private int findOptimalScore(int start, int end, int[] nums, Integer[][] dp) {
        
        if(start > end) {
            
            return 0;
        }
        
        if(dp[start][end] != null) {
            
            return dp[start][end];
        }
        
        int option1 = nums[start] + Math.min(
                                            findOptimalScore(start + 2, end, nums, dp),
                                            findOptimalScore(start + 1, end - 1, nums, dp)
        );
            
        int option2 = nums[end] + Math.min(
                                            findOptimalScore(start + 1, end - 1, nums, dp),
                                            findOptimalScore(start, end - 2, nums, dp)
        );
        
        int maxScore = Math.max(option1, option2);
        
        return dp[start][end] = maxScore;
    }
}