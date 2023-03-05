class Solution {
    public int minJumps(int[] arr) {
        
        int minSteps = BFS(arr);
        
        return minSteps;
    }
    
    private int BFS(int[] arr)
    {
        int n = arr.length;
        int lastIndex = n-1;
        
        Map<Integer,Set<Integer>> map = getMap(arr);
        Set<Integer> visited = new HashSet<>();
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        
        int level = 0;
        
        while(queue.size()>0)
        {
            int len = queue.size();
            
            for(int i=1;i<=len;i++)
            {
                int currIndex = queue.remove();
            
                if(currIndex==lastIndex)
                    return level;
                
                if(visited.contains(currIndex))
                    continue;
                
                visited.add(currIndex);
                
                int nextIndex = currIndex + 1;
                int prevIndex = currIndex - 1;
                
                if(nextIndex<n && visited.contains(nextIndex)==false)
                    queue.add(nextIndex);
                
                if(prevIndex>=0 && visited.contains(prevIndex)==false)
                    queue.add(prevIndex);
                
                Set<Integer> set = map.get(arr[currIndex]);
                
                for(int index : set)
                {
                    if(index!=currIndex && visited.contains(index)==false)
                        queue.add(index);
                }
                
                map.put(arr[currIndex],new HashSet<>());
            }
           
            level++;    
        }
        
        return -1;
    }
    
    private Map<Integer,Set<Integer>> getMap(int[] arr)
    {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.get(arr[i]).add(i);
            }
            else
            {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                
                map.put(arr[i],set);
            }
        }
        
        return map;
    }
}