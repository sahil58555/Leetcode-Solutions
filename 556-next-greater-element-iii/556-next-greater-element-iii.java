class Solution {
    public int nextGreaterElement(int n) {
        
        char[] arr = Integer.toString(n).toCharArray();
        Stack<Integer> stack = new Stack<>();
        int index = -1;
        
        for(int i = arr.length - 1 ; i >= 0 ; i--) {
            
            while(stack.size() > 0 && arr[i] < arr[stack.peek()]) {
                
                index = stack.pop();
            }
            
            if(index != -1) {
                
                swap(arr, i, index);
                Arrays.sort(arr, i + 1, arr.length);
                
                break;
            }
            
            stack.push(i);
        }
        
        if(index == -1) {
            
            return -1;
        }
        
        long num = Long.parseLong(new String(arr));
        
        return (num <= Integer.MAX_VALUE) ? (int)num : -1;
    }
    
    private void swap(char[] arr, int idx1, int idx2) {
        
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}