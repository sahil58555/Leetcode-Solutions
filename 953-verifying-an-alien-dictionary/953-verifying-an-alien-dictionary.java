class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        Map<Character,Integer> index = new HashMap<>();
        
        for(int i = 0 ; i < 26 ; i++) {
            
            index.put(order.charAt(i), i);
        }
        
        int n = words.length;
        
        for(int i = 0 ; i < n - 1 ; i++) {
            
            String curr = words[i];
            String next = words[i + 1];
            
            int first = 0 , second = 0;
            
            while(first < curr.length() && second < next.length()) {
                
                char currChar = curr.charAt(first);
                char nextChar = next.charAt(second);
                
                if(currChar != nextChar) {
                    
                    if(index.get(currChar) > index.get(nextChar)) {
                        
                        return false;
                    }
                    
                    break;
                }
                
                first++;
                second++;
            }
            
            if(first != curr.length() && second == next.length()) {
                
                return false;
            }
        }
        
        return true;
    }
}