class Solution {
    
    private String s1;
    private String s2;
    private int n;
    private Boolean[][][] dp;
    
    public boolean isScramble(String s1, String s2) {
        
        this.n = s1.length();
        this.s1 = s1;
        this.s2 = s2;
        this.dp = new Boolean[n][n][n];
        
        return isScramble(0, n - 1, 0);
    }
    
    private boolean isScramble(int start1, int end1, int start2) {
        
        if(start1 == end1) {
            
            return (s1.charAt(start1) == s2.charAt(start2));
        }
        
        if(dp[start1][end1][start2] != null) {
            
            return dp[start1][end1][start2];
        }
        
        int end2 = start2 + end1 - start1;
        
        for(int i = start1 ; i < end1 ; i++) {
            
            int len = i - start1;
            boolean option1 = isScramble(start1, i, start2) && isScramble(i + 1, end1, start2 + len + 1);
            
            len = i - start1;
            boolean option2 = isScramble(start1, i, end2 - len) && isScramble(i + 1, end1, start2);

            if(option1 || option2) {
                
                return dp[start1][end1][start2] = true;
            }
        }
        
        return dp[start1][end1][start2] = false;
    }
}