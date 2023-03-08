class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;

        long start = 1;
        long end = Arrays.stream(piles).max().getAsInt();
        
        long ans = end;
        
        while(start <= end) {
            
            long mid = (start + end) >> 1;
            
            if(canKokoEatsAllBananasWithInHHours(piles, mid, h)) {
                
                ans = mid;
                end = mid - 1;
            }
            else {
                
                start = mid + 1;
            }
        }
        
        return (int)ans;
    }
    
    private boolean canKokoEatsAllBananasWithInHHours(int[] piles, long speed, int h) {
        
        long sum = 0;
        
        for(int pile : piles) {
            
            sum += (-1l + pile + speed) / speed;
            
            if(sum > h) {
                
                return false;
            }
        }
        
        return true;
    }
}