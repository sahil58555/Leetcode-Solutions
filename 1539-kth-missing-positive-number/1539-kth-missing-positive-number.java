class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int count = 0;
        int idx = 0;
        int number = 1;
        
        while(count < k) {
            
            if(idx < arr.length && arr[idx] == number) {
                idx++;
                number++;
            }
            else {
                
                count++;
                number++;
            }
        }
        
        return number - 1;
    }
}