class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long s = 0;
        long e = Long.MAX_VALUE;
        long ans = 0;
        
        while(s<=e)
        {
            long mid = s + (e-s)/2;
            
            if(check(mid,time,totalTrips))
            {
                ans = mid;
                e = mid-1;
            }
            else
            {
                s = mid + 1;
            }
        }
        
        return ans;
    }
    
    boolean check(long val,int[] time,int trip)
    {
        long sum = 0;
        
        for(int ele : time)
        {
            sum += val/ele;
            
            if(sum>=trip)
                return true;
        }
        
        return false;
    }
}