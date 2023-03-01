class Solution {
    public int[] sortArray(int[] nums) {
     
        quickSort(0, nums.length - 1, nums);
        
        return nums;
    }
    
    private void quickSort(int start, int end, int[] nums) {
        
        if(start > end) {
            
            return ;
        }
        
        int randomIndex = getRandomNumberInRange(start, end);
        swap(nums, randomIndex, end);
        
        int pivot = nums[end];
        int partitionIndex = partitionTheArray(start, end, nums, pivot);
        
        quickSort(start, partitionIndex - 1, nums);
        quickSort(partitionIndex + 1, end, nums);
    }
    
    private int partitionTheArray(int start, int end, int[] nums, int pivot) {
        
        int front = start;
        int back = start;
        
        while(front <= end) {
            
            if(nums[front] <= pivot) {
                
                swap(nums, front, back);
                front++;
                back++;
            }
            else {
                
                front++;
            }
        }
        
        return back - 1;
    }
    
    private void swap(int[] nums, int idx1, int idx2) {
        
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    
    private int getRandomNumberInRange(int start, int end) {
        
        int length = end - start + 1;
        int randomNo = (int)(Math.random() * length) + start;
        
        return randomNo;
    }
}