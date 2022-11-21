class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int ans=-1;
        
        ArrayDeque<Pair> q=new ArrayDeque<>();
        q.add(new Pair(entrance[0],entrance[1],0));
        
        boolean[][] visited=new boolean[maze.length][maze[0].length];
        while(q.size()>0)
        {
            Pair rem=q.remove();
            
            if(visited[rem.i][rem.j])
                continue;
            
            visited[rem.i][rem.j]=true;
            
         //   System.out.println(rem.i +" "+rem.j);
            
            if(!(rem.i==entrance[0] && rem.j==entrance[1]) && (rem.i==0 ||rem.i==maze.length-1 || rem.j==0 || rem.j==maze[0].length-1))
            {
                ans=rem.val;
                break;
            }
            
            if(isAdd(maze,entrance,rem.i-1,rem.j,visited))
                q.add(new Pair(rem.i-1,rem.j,rem.val+1));
            if(isAdd(maze,entrance,rem.i,rem.j+1,visited))
                q.add(new Pair(rem.i,rem.j+1,rem.val+1));
            if(isAdd(maze,entrance,rem.i+1,rem.j,visited))
                q.add(new Pair(rem.i+1,rem.j,rem.val+1));
            if(isAdd(maze,entrance,rem.i,rem.j-1,visited))
                q.add(new Pair(rem.i,rem.j-1,rem.val+1));
            
        }
        
        return ans;
    }
    public boolean isAdd(char[][] maze,int[] entrance,int i,int j,boolean[][] visited)
    {
        if(i<0 || i==maze.length || j<0 || j==maze[0].length || maze[i][j]=='+' || (i==entrance[0] && j==entrance[1]) || visited[i][j])
            return false;
        
        return true;
    }
}
class Pair
{
    int i;
    int j;
    int val;
    
    Pair(int i,int j,int val)
    {
        this.i=i;
        this.j=j;
        this.val=val;
    }
}