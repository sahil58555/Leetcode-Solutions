class Solution {
    public int singleNonDuplicate(int[] a) {
        
        int low=0;
        int high=a.length-1;
        int mid=0;
        
        while(low < high)
        {
            mid=low+(high-low)/2;
            
            if(mid % 2 == 0)
            {
                if(a[mid]==a[mid+1])
                    low = mid + 2;
                else
                    high = mid;
            }
            else
            {
                if(a[mid] == a[mid-1])
                    low = mid + 1;
                else
                    high = mid;
            }
        }
        
        return a[low];
    }
}