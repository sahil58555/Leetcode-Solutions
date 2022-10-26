class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(sum, -1);
        
        for(int i = 0 ; i < nums.length ; i++) {
            
            sum += nums[i];
            int remainder = sum % k;
            
            int prevIdx = map.getOrDefault(remainder, i);
            int size = i - prevIdx;
            
            if(size >= 2) return true;
            
            map.putIfAbsent(remainder, i);
        }
        
        return false;
    }
}





