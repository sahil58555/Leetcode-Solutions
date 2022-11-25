class Solution {
    public int sumSubarrayMins(int[] arr) {
     
        int n = arr.length;
        
        Stack<Integer> stack = new Stack<>();
        
        int[] right = new int[n];
        
        for(int i = n - 1 ; i >= 0 ; i--) {
            
            while(stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
                
                stack.pop();
            }
            
            right[i] = (stack.size() == 0) ? n : stack.peek();
            stack.push(i);
        }
        
        int[] left = new int[n];
        stack = new Stack<>();
        
        for(int i = 0 ; i < n ; i++) {
            
            while(stack.size() > 0 && arr[stack.peek()] > arr[i]) {
                
                stack.pop();
            }
            
            left[i] = (stack.size() == 0) ? -1 : stack.peek();
            stack.push(i);
        }

        long ans = 0;
        int mod = 1000000000 + 7;
        
        for(int i = 0 ; i < n ; i++) {
            
            long len = right[i] - left[i] - 1;
            len = (len + 1l * (i - left[i] - 1) * (right[i] - i - 1)) % mod;
            
            long currVal = 1l * arr[i] * len;
            ans = (ans + currVal) % mod;
        }
        
        return (int)ans;
    }
}