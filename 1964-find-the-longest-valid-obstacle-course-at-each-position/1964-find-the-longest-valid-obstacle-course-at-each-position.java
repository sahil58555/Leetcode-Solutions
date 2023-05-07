class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] arr) {
        
        int n = arr.length;
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++) {
            
            int curr = arr[i];
            
            if(list.size() == 0 || list.get(list.size() - 1) <= curr) {
                
                list.add(curr);
                ans[i] = list.size();
            }
            else {
                
                int index = upperBound(list, 0, list.size() - 1, curr);
                list.set(index, curr);
                ans[i] = index + 1;
            }
        }
        
        return ans;
    }
    
    private int upperBound(List<Integer> nums, int low, int high, int target) {

        int index = high + 1; // default case

        while(low <= high) {

            int mid = (low + high) >> 1;

            if(nums.get(mid) <= target) {

                low = mid + 1;
            }
            else {

                index = mid;
                high = mid - 1;
            }
        }

        return index;
    }
}