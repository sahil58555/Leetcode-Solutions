class Solution {
    public int strStr(String text, String pattern) {
        
        int n = text.length();
        int m = pattern.length();
        
        String str = pattern + "#" + text;
        
        int[] z = getZArray(str);
        
        for(int i = m + 1 ; i < z.length ; i++) {
            
            if(z[i] == m) {
                
                return i - m - 1;
            }
        }
        
        return -1;
    }
    
    private int[] getZArray(String str) {
        
        int n = str.length();
        int[] z = new int[n];
        
        int left = 0, right = 0;
        
        for(int i = 1 ; i < n ; i++) {
            
            if(i <= right) {
                
                z[i] = Math.min(right - i + 1, z[i - left]);
            }
            
            while(i + z[i] < n && str.charAt(z[i]) == str.charAt(i + z[i])) {
                
                z[i]++;
            }
            
            if(i + z[i] - 1 > right) {
                
                left = i;
                right = i + z[i] - 1;
            }
        }
        
        return z;
    }
}