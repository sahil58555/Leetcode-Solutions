class Solution {
    public int searchInsert(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums,target);
        
        if(idx<0)
            idx= (idx*-1)-1;
        return idx;
    }
}