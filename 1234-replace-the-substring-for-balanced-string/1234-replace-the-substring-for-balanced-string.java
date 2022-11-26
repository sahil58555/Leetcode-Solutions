class Solution {
    public int balancedString(String s) {
        
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        
        map.put('Q', 0);
        map.put('W', 0);
        map.put('E', 0);
        map.put('R', 0);
        
        for(char ch : s.toCharArray()) {
            
            map.put(ch, map.get(ch) + 1);
        }
        
        int required = n / 4;
        
        if(isValidMap(map, required)) {
            
            return 0;
        }
        
        int i = -1 , j = -1;
        int ans = n;
        
        while(true) {
            
            boolean seen1 = false;
            boolean seen2 = false;
            
            while(i < n - 1) {
                
                seen1 = true;
                i++;
                
                char ch = s.charAt(i);
                map.put(ch, map.get(ch) - 1);
                
                if(isValidMap(map, required)) {
                    
                    int len = i - j;
                    ans = Math.min(ans, len);
                    break;
                }
            }
            
            while(j < i) {
                
                seen2 = true;
                j++;
                
                char ch = s.charAt(j);
                
                map.put(ch, map.get(ch) + 1);
                
                if(isValidMap(map, required)) {
                    
                    int len = i - j;
                    ans = Math.min(ans, len);
                }
                else {
                    
                    break;
                }
            }
            
            if(seen1 == false && seen2 == false) {
                
                break;
            }
        }
        
        return ans;
    }
    
    private boolean isValidMap(Map<Character,Integer> map, int required) {
        
        for(char ch : map.keySet()) {
            
            if(map.get(ch) > required) return false;
        }
        
        return true;
    }
}