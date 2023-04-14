class Solution {
    public int longestPalindromeSubseq(String s) {
     
        int n = s.length();
        
        int[][] lps = new int[n][n];
        
        for(int gap=0;gap<n;gap++)
        {
            for(int i=0,j=gap;j<n;j++,i++)
            {
                if(gap==0)
                    lps[i][j] = 1;
                else if(gap==1)
                    lps[i][j] = (s.charAt(i)==s.charAt(j)) ? 2 : 1 ; 
                else
                {
                    char ch1 = s.charAt(i);
                    char ch2 = s.charAt(j);
                    
                    if(ch1==ch2)
                    {
                        lps[i][j] = lps[i+1][j-1] + 2;
                    }
                    else
                    {
                        lps[i][j] = Math.max(lps[i+1][j],lps[i][j-1]);
                    }
                }
            }
        }
        
        return lps[0][n-1];
    }
}