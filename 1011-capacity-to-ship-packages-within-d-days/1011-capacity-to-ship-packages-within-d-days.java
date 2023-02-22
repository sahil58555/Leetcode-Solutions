class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int max=Integer.MIN_VALUE;
        int sum=0;
        
        for(int ele : weights)
        {
            max=Math.max(max,ele);
            sum+=ele;
        }
        
        int start=max;
        int end=sum;
        int ans=max;
        
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            
            boolean flag=isPossibleToShip(weights,days,mid);
            
            if(flag)
            {
                ans=mid;
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        
        return ans;
        
    }
    
    public boolean isPossibleToShip(int[] weights,int days,int maxcapacity)
    {
        int count=1;
        int sum=0;
        
        for(int ele : weights)
        {
            if(sum+ele<=maxcapacity)
            {
                sum+=ele;
            }
            else
            {
                sum=ele;
                count++;
            }
        }
        
        return count<=days;
        
    }
}