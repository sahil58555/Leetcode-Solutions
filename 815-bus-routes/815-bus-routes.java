class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        
        for(int i=0;i<routes.length;i++)
        {
            for(int j=0;j<routes[i].length;j++)
            {
                map.compute(routes[i][j], (key, val) -> val == null ? new ArrayList<>() : val).add(i);
                // if(map.containsKey(routes[i][j]))
                // {
                //     map.get(routes[i][j]).add(i);
                // }
                // else
                // {
                //     ArrayList<Integer> l=new ArrayList<>();
                //     l.add(i);
                //     map.put(routes[i][j],l);
                // }
            }
        }
        
        int level=0;
        
        HashSet<Integer> busNo=new HashSet<>();
        HashSet<Integer> busStopNo=new HashSet<>();
        
        
        ArrayDeque<Integer> q=new ArrayDeque<>();
        q.add(source);
        
        while(q.size()!=0)
        {
            int len=q.size();
            
            for(int i=1;i<=len;i++)
            {
                int rem=q.remove();
                
                if(busStopNo.contains(rem))
                    continue;
                
                if(rem==target)
                    return level;
                
                busStopNo.add(rem);
                
                ArrayList<Integer> list=map.get(rem);
                
                for(int ele : list)
                {
                    if(busNo.contains(ele))
                        continue;
                    
                    for(int stop : routes[ele])
                    {
                        if(!busStopNo.contains(stop))
                            q.add(stop);
                    }
                    
                    busNo.add(ele);
                }
            }
            
            level++;
        }
        
        return -1;
    }
    
   
}