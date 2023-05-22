class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = getFreqMap(nums);
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((obj1,obj2)->{
            
            return Integer.compare(obj1.freq,obj2.freq);
        });
        
        for(int key : map.keySet())
        {
            if(queue.size()<k)
                queue.add(new Pair(key,map.get(key)));
            else
            {
                if(map.get(key)>queue.peek().freq)
                {
                    queue.remove();
                    queue.add(new Pair(key,map.get(key)));
                }
            }
        }
        
        int[] arr = new int[k];
        int idx = k - 1;
        
        while(queue.size()>0)
            arr[idx--] = queue.remove().val;
        
        return arr;
        
    }
    
    private Map<Integer,Integer> getFreqMap(int[] nums)
    {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        return map;
    }
}

class Pair
{
    int val;
    int freq;
    
    Pair(int val,int freq)
    {
        this.val = val;
        this.freq = freq;
    }
}