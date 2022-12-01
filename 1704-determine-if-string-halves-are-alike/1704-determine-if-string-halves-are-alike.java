class Solution {
    public boolean halvesAreAlike(String s) {
        
        int n = s.length();
        
        int count1 = 0;
        char[] vowels =  {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        
        for(int i = 0 ; i < n / 2 ; i++) {
            
            char ch = s.charAt(i);
            
            for(char vowel : vowels) {
                
                if(ch == vowel) {
                    
                    count1++;
                }
            }
        }
        
        int count2 = 0;
        
        for(int i = n / 2 ; i < n ; i++) {
            
            char ch = s.charAt(i);
            
            for(char vowel : vowels) {
                
                if(ch == vowel) {
                    
                    count2++;
                }
            }
        }
        
        return (count1 == count2);
    }
}