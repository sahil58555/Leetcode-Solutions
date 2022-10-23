class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int diff = 0;
        int sqDiff = 0;
        
        for(int i = 0 ; i < nums.length ; i++) {
            
            int curr = (i +  1);
            
            diff += curr - nums[i];
            sqDiff += (curr * curr) - (nums[i] * nums[i]);
            
        }
        
        int sum = sqDiff / diff;
        
        return new int[]{(sum - diff) / 2, (sum + diff) / 2};
    }
}