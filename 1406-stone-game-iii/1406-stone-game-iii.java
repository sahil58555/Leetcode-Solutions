class Solution {
    public String stoneGameIII(int[] stoneValue) {
        
        int sum = Arrays.stream(stoneValue).sum();
        Integer[] dp = new Integer[stoneValue.length];
        
        int aliceScore = aliceScore(0, stoneValue, dp);
        int bobScore = sum - aliceScore;
        
        if(aliceScore == bobScore) {
            
            return "Tie";
        }
        
        return aliceScore > bobScore ? "Alice" : "Bob";
    }
    
    private int aliceScore(int idx, int[] stones, Integer[] dp) {
        
        if(idx >= stones.length) {
            
            return 0;
        }
        
        if(dp[idx] != null) {
            
            return dp[idx];
        }
        
        int maxScore = -100000000;
        int sum = 0;
        
        for(int i = idx ; i < idx + 3 && i < stones.length; i++) {
            
            sum += stones[i];
            int minScore = 100000000;
            
            for(int j = i + 2 ; j < i + 5 ; j++) {
                
                minScore = Math.min(minScore, aliceScore(j, stones, dp));
            }
            
            maxScore = Math.max(maxScore, minScore + sum);
        }
        
        return dp[idx] = maxScore;
    }
}