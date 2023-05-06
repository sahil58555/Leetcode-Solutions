class Solution {
    public int numSubseq(int[] nums, int target) {
        
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0;
        int mod = 1000000000 + 7;
        
        for(int i = 0 ; i < n ; i++) {
            
            int newTarget = target - nums[i];
            int index = upperBound(nums, 0, n - 1, newTarget);
            int length = index - i - 1;
            
            if(length >= 0) {
            
                ans = (ans + pow(2, length)) % mod;
            }
        }
        
        return (int)ans;
    }
    
    private int upperBound(int[] nums, int low, int high, int target) {

        int index = high + 1; // default case

        while(low <= high) {

            int mid = (low + high) >> 1;

            if(nums[mid] <= target) {

                low = mid + 1;
            }
            else {

                index = mid;
                high = mid - 1;
            }
        }

        return index;
    }
    
    long pow(long a,long n) {
        
        int mod = 1000000000 + 7;
        
        long res = 1;
        
        while(n > 0) {
            
            if(n % 2 == 1) {
                
                res = (res * a) % mod;
                n--;
            }
            else {
                
                a = (a * a) % mod;
                n = n / 2;
            }
        }
        
        return res;
    }
}