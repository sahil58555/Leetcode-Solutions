class Solution {
    
    List<List<Integer>> piles;
    int[][] dp;
    
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        this.piles = piles;
        dp = new int[piles.size()][k+1];
        
        for(int[] oneD : dp)
            Arrays.fill(oneD,-1);
        
        return solve(0,k);
    }
    
    int solve(int idx,int k)
    {
        if(idx==piles.size())
        {
            return 0;
        }
        
        if(dp[idx][k]!=-1)
            return dp[idx][k];
        
        int option1 = solve(idx+1,k);
        int option2 = 0;
        int sum = 0;
        
        List<Integer> pile = piles.get(idx); 
        
        for(int i=0;i<pile.size() && i<k;i++)
        {
            sum += pile.get(i);
            
            option2 = Math.max(option2,sum + solve(idx+1,k-i-1));
        }
        
        return dp[idx][k] = Math.max(option1,option2);
    }
}