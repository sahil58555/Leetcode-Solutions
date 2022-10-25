class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
     
        int iterator1 = 0;
        int iterator2 = 0;
        
        int idx1 = 0 , idx2 = 0;
        
        while(true) {
            
            if(idx1 == word1[iterator1].length()) {
                
                idx1 = 0;
                iterator1++;
            }
            
            if(idx2 == word2[iterator2].length()) {
                
                idx2 = 0;
                iterator2++;
            }
            
            if(iterator1 == word1.length || iterator2 == word2.length) break;
            
            if(word1[iterator1].charAt(idx1) != word2[iterator2].charAt(idx2)) return false;
            
            idx1++;
            idx2++;
        }
        
        return (iterator1 == word1.length && iterator2 == word2.length);
    }
}