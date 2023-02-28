class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int product = 1;
        
        for(int num : nums) {
            
            product *= num;
            ans = Math.max(ans, product);
            
            if(product == 0) {
                
                product = 1;
            }
        }
        
        product = 1;
        
        for(int i = n - 1 ; i >= 0 ; i--) {
            
            product *= nums[i];
            ans = Math.max(ans, product);
            
            if(product == 0) {
                
                product = 1;
            }
        }
        
        return ans;
    }
}