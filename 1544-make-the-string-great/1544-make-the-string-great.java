class Solution {
    public String makeGood(String s) {
        
        StringBuilder ans = new StringBuilder();
        
        for(char ch : s.toCharArray()) {
            
            if(Character.isLowerCase(ch)) {
                
                if(ans.length() > 0 && Character.isUpperCase(ans.charAt(ans.length() - 1)) && (ch == Character.toLowerCase(ans.charAt(ans.length() - 1)))) {
                    
                    ans.deleteCharAt(ans.length() - 1);
                }
                else{
                    
                    ans.append(ch);
                }
            }
            else{
            
                if(ans.length() > 0 && Character.isLowerCase(ans.charAt(ans.length() - 1)) && (ch == Character.toUpperCase(ans.charAt(ans.length() - 1)))) {
                    
                    ans.deleteCharAt(ans.length() - 1);
                }
                else{
                    
                    ans.append(ch);
                }
            }
            
        }
        
        return ans.toString();
    }
}