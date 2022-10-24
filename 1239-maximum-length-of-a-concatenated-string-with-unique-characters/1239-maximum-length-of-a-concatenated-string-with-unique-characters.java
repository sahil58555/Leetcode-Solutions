class Solution {
    static int count=0;
    public int maxLength(List<String> arr) {
        
        count=0;
        find("",new HashSet<Character>(),0,arr);
        
        return count;
        
    }
    
    public void find(String s,HashSet<Character> h,int idx,List<String> l)
    {
        if(idx==l.size())
        {
            count=Math.max(count,s.length());
            return;
        }
        
        find(s,h,idx+1,l);
        
        String str=l.get(idx);
        boolean flag=false;
        HashSet<Character> hs=new HashSet<>();
        
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(h.contains(ch) || hs.contains(ch))
            {
                return;
            }    
            hs.add(ch);
        }
        
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
               
            h.add(ch);
        }
        
       
        
        find(s+str,h,idx+1,l);
        
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            h.remove(ch);
        }
        
        return;
        
    }
}