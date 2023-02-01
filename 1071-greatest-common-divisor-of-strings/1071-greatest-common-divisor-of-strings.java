class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        int n = str1.length();
        int m = str2.length();
        
        for(int i = Math.min(n, m) ; i > 0 ; i--) {

            String target = str1.substring(0, i);
            
            if(isTargetDividesString(str1, target) && isTargetDividesString(str2, target)) {
                
                return target;
            }
        }
        
        return "";
    }
    
    private boolean isTargetDividesString(String str, String target) {
        
        int n = str.length();
        int m = target.length();
        
        if((n % m) != 0) {
            
            return false;
        }
        
        for(int i = 0 ; i < n ; i += m) {
            
            String curr = str.substring(i, i + m);

            if(!curr.equals(target)) {
                
                
                return false;
            }
        }
        
        return true;
    }
}