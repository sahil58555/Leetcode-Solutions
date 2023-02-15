class Solution {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        
        List<Integer> ans = new ArrayList<>();
        int idx = nums.length - 1;
        int carry = 0;
        
        while(idx >= 0 && k > 0) {
            
            int sum = nums[idx] + k % 10 + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            
            k /= 10;
            idx--;
        }
        
        while(idx >= 0) {
            
            int sum = nums[idx] + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            
            idx--;
        }
        
        while(k > 0) {
            
            int sum = k % 10 + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            
            k /= 10;
        }
        
        if(carry == 1) {
            
            ans.add(carry);
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}