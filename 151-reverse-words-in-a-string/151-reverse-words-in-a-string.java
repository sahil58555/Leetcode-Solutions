class Solution {
    public String reverseWords(String s) {
        
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        
        int i = 0;
        
        while(i<s.length())
        {
            
            while(i<n && s.charAt(i)==' ')
                i++;
            
            StringBuilder word = new StringBuilder();
            
            while(i<n && s.charAt(i)!=' ')
            {
                word.append(s.charAt(i));
                i++;
            }
            
            ans.insert(0," "+word);
        }
        
        return ans.toString().trim();
    }
}