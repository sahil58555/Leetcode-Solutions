class Solution {
    public int countOdds(int low, int high) {
        
        if(low % 2 == 1) {
            
            low--;
        }
        
        if(high % 2 == 1) {
            
            high++;
        }
        
        int len = high - low;
        int countOfOddNumbers = len / 2;
        
        return countOfOddNumbers;
    }
}