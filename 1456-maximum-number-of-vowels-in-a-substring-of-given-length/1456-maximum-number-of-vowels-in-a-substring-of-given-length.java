class Solution {
    public int maxVowels(String s, int k) {
        
        String vowel = "aeiou";
        int n = s.length();
        int count = 0;
        
        for(int i = 0 ; i < k ; i++) {
            
            char ch = s.charAt(i);
            
            if(vowel.indexOf(ch) != -1) {
                
                count++;
            }
        }
        
        int ans = count;
        
        for(int i = k ; i < n ; i++) {
            
            char inc = s.charAt(i);
            char exc = s.charAt(i - k);
            
            if(vowel.indexOf(inc) != -1) {
                
                count++;
            }
            
            if(vowel.indexOf(exc) != -1) {
                
                count--;
            }
            
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
}