class MapSum {

    private Map<String, Integer> map;
    private Map<String, Integer> seen;
    
    public MapSum() {
        
        map = new HashMap<>();
        seen = new HashMap<>();
    }
    
    public void insert(String key, int val) {
     
        int n = key.length();
        
        if(seen.containsKey(key)) {
            
            for(int j = 0 ; j < n ; j++) {
                
                String subStr = key.substring(0, j + 1);
                map.put(subStr, sum(subStr) + -1 * seen.get(key));
            }
        }
        
        seen.put(key, val);
        
        for(int j = 0 ; j < n ; j++) {
                
            String subStr = key.substring(0, j + 1);
            map.put(subStr, sum(subStr) + val);
        }
    }
    
    public int sum(String prefix) {
     
        return map.getOrDefault(prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */