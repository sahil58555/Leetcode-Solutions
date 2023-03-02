class Solution {
    public int compress(char[] chars) {
     
        int ans = 0;
        int count = 0;
        char prev = '.';
        int idx = 0;
        
        for(char ch : chars) {
            
            if(prev == ch) {
                
                count++;
            }
            else {
                
                if(count > 1) {
                    
                    String num = (count + "");
                    ans += num.length();
                    
                    for(char digit : num.toCharArray()) {
                        
                        chars[idx++] = digit;
                    }
                }
                
                count = 1;
                ans++;
                chars[idx++] = ch;
                prev = ch;
            }
        }
        
        if(count > 1) {
                    
            String num = (count + "");
            ans += num.length();
                    
            for(char digit : num.toCharArray()) {
                        
                chars[idx++] = digit;
            }
        }
        
        return ans;
    }
}