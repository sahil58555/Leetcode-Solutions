class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int n = arr.length;
        
        int[] rightMin = new int[n + 1];
        rightMin[n] = Integer.MAX_VALUE;
        
        int min = arr[n - 1];
        
        for(int i = n - 1 ; i >= 0 ; i--) {
            
            min = Math.min(min , arr[i]);
            rightMin[i] = min;
        }
        
        int ans = 0;
        int leftMax = arr[0];
        
        for(int i = 0 ; i < n ; i++) {
            
            leftMax = Math.max(leftMax, arr[i]);
            
            if(leftMax <= rightMin[i + 1]) {
                
                ans++;
            }
        }
        
        return ans;
    }
}