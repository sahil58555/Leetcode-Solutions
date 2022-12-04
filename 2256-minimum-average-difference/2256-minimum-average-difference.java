class Solution {
    public int minimumAverageDifference(int[] nums) {
     
        int n = nums.length;
        long sum = 0;
        
        for(int num : nums) {
            
            sum += num;
        }
        
        long minAvgDiff = Long.MAX_VALUE;
        int ans = 0;
        long leftSum = 0;
        
        for(int i=0;i<n;i++) {
            
            leftSum += nums[i];
            
            long rightSum = sum - leftSum;
            
            long avg1 = leftSum / (i + 1);
            long avg2 = (n - i - 1 == 0) ? 0 : rightSum / (n - i - 1);
            
            long diff = Math.abs(avg1 - avg2);
            
            if(diff < minAvgDiff) {
                
                minAvgDiff = diff;
                ans = i;
            }
        }
        
        return ans;
    }
}