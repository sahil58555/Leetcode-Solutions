class Solution {
    
    private String s1;
    private String s2;
    private int n;
    private Boolean[][][][] dp;
    
    public boolean isScramble(String s1, String s2) {
        
        this.n = s1.length();
        this.s1 = s1;
        this.s2 = s2;
        this.dp = new Boolean[n][n][n][n];
        
        return isScramble(0, n - 1, 0, n - 1);
    }
    
    private boolean isScramble(int start1, int end1, int start2, int end2) {
        
        if(start1 == end1) {
            
            return (s1.charAt(start1) == s2.charAt(start2));
        }
        
        if(dp[start1][end1][start2][end2] != null) {
            
            return dp[start1][end1][start2][end2];
        }
        
        for(int i = start1 ; i < end1 ; i++) {
            
            int len = i - start1;
            boolean option1 = isScramble(start1, i, start2, start2 + len) && isScramble(i + 1, end1, start2 + len + 1, end2);
            
            len = i - start1;
            boolean option2 = isScramble(start1, i, end2 - len, end2) && isScramble(i + 1, end1, start2, end2 - len - 1);

            if(option1 || option2) {
                
                return dp[start1][end1][start2][end2] = true;
            }
        }
        
        return dp[start1][end1][start2][end2] = false;
    }
}