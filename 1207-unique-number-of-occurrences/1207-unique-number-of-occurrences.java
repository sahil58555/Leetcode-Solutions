class Solution {
    public boolean uniqueOccurrences(int[] arr) {
     
        Map<Integer,Integer> freqMap = new HashMap<>();
        
        for(int ele : arr) {
            
            freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);
        }
        
        Set<Integer> seen = new HashSet<>();
        
        for(int key : freqMap.keySet()) {
            
            if(seen.contains(freqMap.get(key))) {
                
                return false;
            }
            
            seen.add(freqMap.get(key));
        }
        
        return true;
    }
}