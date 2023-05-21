class Solution {
    public int shortestBridge(int[][] grid) {
        
        ArrayDeque<Node> q=new ArrayDeque<>();
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        
        xyz :
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    DFS(grid,visited,q,i,j);
                    break xyz;
                }
            }
        }
        
       // System.out.println(q.size());
        
        int ans=0;
        
        while(q.size()!=0)
        {
            Node rem=q.remove();
            
            if(grid[rem.i][rem.j]==0)
            {
                if(visited[rem.i][rem.j])
                    continue;
            }
            else
            {
                if(!visited[rem.i][rem.j])
                {
                    ans=rem.count;
                    break;
                }  
            }
            
            visited[rem.i][rem.j]=true;
            
            if(isValid(grid,visited,rem.i-1,rem.j))
                q.add(new Node(rem.i-1,rem.j,rem.count+1));
            if(isValid(grid,visited,rem.i,rem.j+1))
                q.add(new Node(rem.i,rem.j+1,rem.count+1));
            if(isValid(grid,visited,rem.i+1,rem.j))
                q.add(new Node(rem.i+1,rem.j,rem.count+1));
            if(isValid(grid,visited,rem.i,rem.j-1))
                q.add(new Node(rem.i,rem.j-1,rem.count+1));
            
            
        }
        
        return ans-1;
        
    }
    
    public void DFS(int[][] grid,boolean[][] visited,ArrayDeque<Node> q,int i,int j)
    {
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || visited[i][j] || grid[i][j]==0)
            return;
        
        visited[i][j]=true;
        
        q.add(new Node(i,j,0));
        
        DFS(grid,visited,q,i-1,j);
        DFS(grid,visited,q,i,j+1);
        DFS(grid,visited,q,i+1,j);
        DFS(grid,visited,q,i,j-1);
    }
    
    public boolean isValid(int[][] grid,boolean[][] visited,int i,int j)
    {
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || visited[i][j])
            return false;
        
        return true;
    }
}

class Node
{
    int i;
    int j;
    int count;
    
    Node(int i,int j,int count)
    {
        this.i=i;
        this.j=j;
        this.count=count;
    }
}