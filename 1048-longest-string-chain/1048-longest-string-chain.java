class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words,(word1,word2) -> Integer.compare(word1.length(),word2.length()));

        
        int n = words.length;
        Map<String, Integer> dp = new HashMap<>();
        int longestChain = 0;
        
        for(String word : words) {
            
            int currLongestChain = 0;
            
            for(int i = 0 ; i < word.length() ; i++) {
                
                String prev = word.substring(0, i) + word.substring(i + 1);
                currLongestChain = Math.max(currLongestChain, dp.getOrDefault(prev, 0));
            }
            
            currLongestChain++;
            
            dp.put(word, currLongestChain);
            longestChain = Math.max(longestChain, currLongestChain);
        }
        
        return longestChain;
    }
}