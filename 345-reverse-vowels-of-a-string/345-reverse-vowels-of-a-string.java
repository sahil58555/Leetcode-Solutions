class Solution {
    public String reverseVowels(String s) {
        
        char[] ch = s.toCharArray();
        
        int n = s.length();
        int i = 0 , j = n - 1;
        
        while(i < j) {
            
            while(i < n && isVowel(ch[i]) == false) i++;
            
            while(j >= 0 && isVowel(ch[j]) == false) j--;
            
            if(i < j) {
                
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                
            }
            
            i++;
            j--;
        }
        
        return new String(ch);
    }
    
    private boolean isVowel(char ch) {
        
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        
        for(char vowel : vowels) {
            
            if(ch == vowel) return true;
        }
        
        return false;
    }
}