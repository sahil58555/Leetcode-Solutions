class Solution {
    public int longestPalindrome(String[] words) {
     
        Map<String,Integer> map = new HashMap<>();
        
        for(String word : words)
        {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        
        int count = 0;
        int max = 0;
        
        for(String key : map.keySet())
        {
            String revKey = getReverse(key);
            
            if(map.containsKey(revKey))
            {
                if(key.equals(revKey))
                {
                    if(map.get(key)%2==1)
                        max = 1;
                    
                    count += 2 * (map.get(key)/2);
                }
                else
                {
                    count += 2 * Math.min(map.get(key),map.get(revKey));
                }
            }
            
            map.put(key,0);
        }
        
        return count * 2 + max * 2;
    }
    
    private String getReverse(String str)
    {
        String rev = (new StringBuilder(str)).reverse().toString();
        
        return rev;
    }
}