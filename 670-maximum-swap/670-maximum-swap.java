class Solution {
    public int maximumSwap(int num) {
        
        String maxNum = num + "";
        char[] arr = maxNum.toCharArray();
        int n = maxNum.length();
        
        int[] max = new int[n];
        max[n - 1] = n - 1;
        
        for(int i = n - 2 ; i >= 0 ; i--) {
            
            if(arr[i] > arr[max[i + 1]]) {
                
                max[i] = i;
            }
            else {
                
                max[i] = max[i + 1];
            }
        }
        
        for(int i = 0 ; i < n ; i++) {
            
            if(arr[i] < arr[max[i]]) {
                
                swap(arr, i, max[i]);
                String curr = new String(arr);
                
                if(curr.compareTo(maxNum) > 0) {
                    
                    maxNum = curr;
                }
                
                swap(arr, i, max[i]);
                break;
            }
        }
        
        return Integer.parseInt(maxNum);
    }
    
    private void swap(char[] arr, int idx1, int idx2) {
        
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}