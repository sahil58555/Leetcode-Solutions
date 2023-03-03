class Solution {
    public int strStr(String text, String pattern) {
        
        int n = text.length();
        int m = pattern.length();
        
        String str = pattern + "#" + text;
        
        int[] lps = getLPSArray(str);
        
        for(int i = m + 1 ; i < lps.length ; i++) {
            
            if(lps[i] == m) {
                
                return i - 2 * m;
            }
        }
        
        return -1;
    }
    
    private int[] getLPSArray(String str) {
        
        int n = str.length();
        int[] lps = new int[n];
        
        int i = 1 , length = 0;
        
        while(i < n) {
            
            if(str.charAt(i) == str.charAt(length)) {
                
                length++;
                lps[i] = length;
                i++;
            }
            else {
                
                if(length > 0) {
                    
                    length = lps[length - 1];
                }
                else {
                    
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}