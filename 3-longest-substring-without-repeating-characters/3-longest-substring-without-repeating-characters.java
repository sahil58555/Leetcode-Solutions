class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int maxLen = 0;
        int j = -1;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                j = Math.max(j,map.get(s.charAt(i)));
            }
            
            maxLen = Math.max(maxLen,i-j);
            
            
            map.put(s.charAt(i),i);
        }
        
        return maxLen;
    }
}