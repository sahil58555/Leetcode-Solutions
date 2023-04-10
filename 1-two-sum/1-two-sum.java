class Solution {
    public int[] twoSum(int[] nums, int target) {
     
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++) {
            
            int newTarget = target - nums[i];
            
            if(map.containsKey(newTarget)) {
                
                return new int[]{i, map.get(newTarget)};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[0];
    }
}