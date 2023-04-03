class Solution {
    public String longestPalindrome(String s) {
        
        
    int n = s.length();
    String longestPal = "";
    
    // Check all possible center positions
    for (int i = 0; i < n; i++) {
        // Check for odd-length palindromes
        int l = i, r = i;
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        String currPal = s.substring(l+1, r);
        if (currPal.length() > longestPal.length()) {
            longestPal = currPal;
        }
        
        // Check for even-length palindromes
        l = i;
        r = i+1;
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        currPal = s.substring(l+1, r);
        if (currPal.length() > longestPal.length()) {
            longestPal = currPal;
        }
    }
    
    return longestPal;


    }
}