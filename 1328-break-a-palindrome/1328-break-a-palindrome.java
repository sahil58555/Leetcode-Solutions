class Solution {
    public String breakPalindrome(String palindrome) {
        
        int n = palindrome.length();
        
        if(n == 1) return "";
        
        int idx = 0;
        
        while(idx < n && palindrome.charAt(idx) == 'a') idx++;
        
        if(idx == n / 2 && n % 2 == 1) {
            
            idx++;
            while(idx < n && palindrome.charAt(idx) == 'a') idx++;
        }
        
        String ans = (idx == n) ? (palindrome.substring(0,idx - 1) + 'b') : (palindrome.substring(0,idx) + 'a' + palindrome.substring(idx + 1));
        
    
        return ans;
    }
}