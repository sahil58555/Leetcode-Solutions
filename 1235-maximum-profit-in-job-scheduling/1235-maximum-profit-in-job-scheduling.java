class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
     
        int n = startTime.length;
        Pair[] pair = new Pair[n];
        
        for(int i = 0 ; i < n ; i++) {
            
            pair[i] = new Pair(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(pair, (pair1, pair2) -> {
            
           return Integer.compare(pair1.startTime, pair2.startTime); 
        });
        
        int[] dp = new int[n + 1];
        
        for(int i = n - 1 ; i >= 0 ; i--) {
            
            int op1 = dp[i + 1];
            int index = binarySearch(pair, pair[i].endTime);
            
            int op2 = pair[i].profit + dp[index];
            
            dp[i] = Math.max(op1, op2);
        }
        
        return dp[0];
    }
    
    private int binarySearch(Pair[] pair, int target) {
        
        int n = pair.length;
        int ans = n;
        
        int low = 0, high = n - 1;
        
        while(low <= high) {
            
            int mid = low + (high - low) / 2;
            
            if(pair[mid].startTime >= target) {
                
                ans = mid;
                high = mid - 1;
            }
            else {
                
                low = mid + 1;
            }
        }
        
        return ans;
    }
}

class Pair {
    
    int startTime;
    int endTime;
    int profit;
    
    Pair(int startTime, int endTime, int profit) {
        
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}