class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n = s1.length();
        int n2 = s2.length();
        
        if(n>n2)
            return false;
        
        Map<Character,Integer> map = getMap(s1);
        
        int front = 0 , back = 0 ;
        
        Map<Character,Integer> curr = new HashMap<>();
        
        while(front<n)
        {
            char ch = s2.charAt(front);
            
            curr.put(ch,curr.getOrDefault(ch,0)+1);
            
            front++;
        }
        
        if(map.equals(curr))
            return true;
        
        while(front<n2)
        {
            char ch = s2.charAt(front);
            
            curr.put(ch,curr.getOrDefault(ch,0)+1);
            
            ch = s2.charAt(back);
            
            curr.put(ch,curr.get(ch)-1);
            
            if(curr.get(ch)==0)
                curr.remove(ch);
            
            if(map.equals(curr))
                return true;
            
            front++;
            back++;
        }
        
        return false;
    }
    
    Map<Character,Integer> getMap(String str)
    {
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        return map;
    }
}