class Solution {
    
    private int[][] colCount;
    private String[] words;
    private String target;
    
    public int numWays(String[] words, String target) {
        
        this.words = words;
        this.target = target;
        
        preComputeColCount();
        
        Long[][] dp = new Long[target.length()][words[0].length()];
        
        return (int)sol(0, 0, dp); 
    }
    
    private long sol(int targetIndex, int wordIndex, Long[][] dp) {
        
        if(targetIndex == target.length()) {
            
            return 1;
        }
        
        if(wordIndex == words[0].length()) {
            
            return 0;
        }
        
        if(dp[targetIndex][wordIndex] != null) {
            
            return dp[targetIndex][wordIndex];
        }
        
        int mod = 1000000000 + 7;
        long notTaken = sol(targetIndex, wordIndex + 1, dp);
        
        char ch = target.charAt(targetIndex);
        long taken = (colCount[wordIndex][ch - 'a'] * sol(targetIndex + 1, wordIndex + 1, dp)) % mod;
        
        long totalWays = (taken + notTaken) % mod;
        
        return dp[targetIndex][wordIndex] = totalWays;
    }
    
    private void preComputeColCount() {
        
        int n = words.length;
        int m = words[0].length();
        
        colCount = new int[m][26];
        
        for(int i = 0 ; i < m ; i++) {
            
            for(int j = 0 ; j < n ; j++) {
                
                char ch = words[j].charAt(i);
                colCount[i][ch - 'a']++;
            }
        }
    }
}