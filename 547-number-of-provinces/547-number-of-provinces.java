class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        
        DisjointSet dsu = new DisjointSet(n);
        
        for(int i = 0 ; i < n ; i++) {
            
            for(int j = 0 ; j < n ; j++) {
                
                if(isConnected[i][j] == 1) {
                    
                    dsu.union(i, j);
                }
            }
        }
        
        return dsu.size;
    }
}

class DisjointSet
{
    int[] parent;
    int[] rank;
    int size;
    
    DisjointSet(int n)
    {
        parent=new int[n];
        rank=new int[n];
        size = n;
        
        for(int i=0;i<n;i++)
            parent[i] = i;
        
        Arrays.fill(rank,1);
    }
    
    public int find(int x)
      {
          if(parent[x]==x) return x;
          
          int temp=find(parent[x]);
          parent[x]=temp;
          return temp;
      }
  
    public boolean union(int x,int y)
      {
          int px=find(x);
          int py=find(y);
          
          if(px!=py)
          {
              size--;
              if(rank[px]>rank[py])
                parent[py]=px;
              else if(rank[px]<rank[py])
                parent[px]=py;
              else
              {
                  parent[px]=py;
                  rank[py]++;
              }
              
              return true;
          }
          
          return false;
      }
        
}