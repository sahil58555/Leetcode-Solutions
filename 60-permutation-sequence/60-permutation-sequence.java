class Solution {
    public String getPermutation(int n, int k) {
        
        int[] nums = new int[n];
        
        for(int i = 1 ; i <= n ; i++) {
            
            nums[i - 1] = i;
        }
        
        int count = 1;
        
        while(count < k) {
            
            count++;
            nextPermutation(nums);
        }
        
        return Arrays.toString(nums).replace(", ","").replace("[","").replace("]","");
    }
    
    public void nextPermutation(int[] nums) {
     
        if(nums==null || nums.length==1)
            return ;
        
        int idx1 = -1;
        int idx2 = -1;
        int n = nums.length;
        
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                idx1 = i;
                break;
            }
        }
        
        if(idx1==-1)
        {
            //array is decreasing
            
            reverse(nums,0,n-1);
            
            return;
        }
        
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]>nums[idx1])
            {
                idx2 = i;
                break;
            }
        }
        
        swap(nums,idx1,idx2);
        
        reverse(nums,idx1+1,n-1);
        
        return;
    }
    
    private void swap(int[] nums,int idx1,int idx2)
    {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    
    private void reverse(int[] nums,int start,int end)
    {
        while(start<end)
        {
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}