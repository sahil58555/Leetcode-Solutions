class Solution {
    public int removeStones(int[][] stones) {
        
        Map<Integer,List<Integer>> row = new HashMap<>();
        Map<Integer,List<Integer>> col = new HashMap<>();
        int idx = 0;
        
        for(int[] stone : stones) {
            
            int x = stone[0];
            int y = stone[1];
            
            row.putIfAbsent(x, new ArrayList<>());
            col.putIfAbsent(y, new ArrayList<>());
            
            row.get(x).add(idx);
            col.get(y).add(idx);
            
            idx++;
        }
        
        int n = stones.length;
        DisjointSet dsu = new DisjointSet(n);
        
        union(dsu, row);
        union(dsu, col);
        
        return n - dsu.size;
    }
    
    private void union (DisjointSet dsu, Map<Integer,List<Integer>> map) {
        
        for(int key : map.keySet()) {
            
            List<Integer> list = map.get(key);
            
            for(int ele : list) {
                
                dsu.union(ele, list.get(0));
            }
        }
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