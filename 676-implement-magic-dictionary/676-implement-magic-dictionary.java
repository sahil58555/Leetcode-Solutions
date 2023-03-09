class MagicDictionary {

    private Set<Long> set;
    private long prime = 31;
    private int mod = 1000000000 + 7;
    
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        
        set = new HashSet<>();
        
        for(String word : dictionary) {
            
            long hash = rollingHash(word);
            set.add(hash);
        }
    }
    
    public boolean search(String searchWord) {
        
        long hash = rollingHash(searchWord);
        int n = searchWord.length();
        long power = 1;
        
        for(int i = 0 ; i < n ; i++) {
         
            char curr = searchWord.charAt(i);
            
            for(char ch = 'a' ; ch <= 'z' ; ch++) {
                
                if(ch != curr) {
                    
                    long include = ((ch - 'a' + 1) * power) % mod;
                    long exclude = ((curr - 'a' + 1) * power) % mod;
                    
                    long currHash = (hash + include - exclude + mod) % mod;
                    
                    if(set.contains(currHash)) {

                        return true;
                    }
                }
            }
            
            power = (power * prime) % mod;
        }
        
        return false;
    }
    
    private long rollingHash(String word) {
        
        long hash = 0;
        int n = word.length();
        long power = 1;
        
        for(int i = 0 ; i < n ; i++) {
            
            char ch = word.charAt(i);
            hash = (hash + (ch - 'a' + 1) * power) % mod;
            power = (power * prime) % mod;
        }
        
        return hash;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */