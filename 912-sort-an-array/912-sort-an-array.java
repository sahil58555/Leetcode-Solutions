class Solution {
    public int[] sortArray(int[] nums) {
    
        return mergeSort(0, nums.length - 1, nums);
    }
    
    private int[] mergeSort(int low, int high, int[] nums) {
        
        if(low == high) {
            
            return new int[]{nums[low]};
        }
        
        int mid = (low + high) >> 1;
        
        int[] left = mergeSort(low, mid, nums);
        int[] right = mergeSort(mid + 1, high, nums);
        
        int[] result = merge(left, right);
        
        return result;
    }
    
    private int[] merge(int[] left, int[] right) {
        
        int n = left.length;
        int m = right.length;
        
        int[] ans = new int[n + m];
        int idx = 0;
        
        int first = 0, second = 0;
        
        while(first < n && second < m) {
            
            if(left[first] <= right[second]) {
                
                ans[idx++] = left[first++];
            }
            else {
                
                ans[idx++] = right[second++];
            }
        }
        
        while(first < n) {
            
            ans[idx++] = left[first++];
        }
        
        while(second < m) {
            
            ans[idx++] = right[second++];
        }
        
        return ans;
    }
}