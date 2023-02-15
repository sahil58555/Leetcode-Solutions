class Solution {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        
        List<Integer> ans = new ArrayList<>();
        int idx = nums.length - 1;
        int carry = 0;
        
        while(idx >= 0 || k > 0 || carry == 1) {
            
            int digitAtNum = (idx < 0) ? 0 : nums[idx];
            int digitAtK = (k <= 0) ? 0 : k % 10;
            
            int sum = digitAtNum + digitAtK + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            
            k /= 10;
            idx--;
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}