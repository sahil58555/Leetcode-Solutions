class Solution {
    
    boolean flag;
    int count;
    
    public int numEnclaves(int[][] grid) {
        
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        
        int ans=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1 && !visited[i][j])
                {
                    flag=true;
                    count=0;
                    DFS(grid,visited,i,j);
                    
                    if(flag)
                        ans+=count;
                }    
            }
        }
        
        return ans;
        
    }
    
    public void DFS(int[][] grid,boolean[][] visited,int i,int j)
    {
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]==0 || visited[i][j])
            return;
        
        if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1)
        {
            flag=false;
        }
        
        visited[i][j]=true;
        count++;
        
         DFS(grid,visited,i-1,j);
         DFS(grid,visited,i,j-1);
         DFS(grid,visited,i+1,j);
         DFS(grid,visited,i,j+1);
    }
}