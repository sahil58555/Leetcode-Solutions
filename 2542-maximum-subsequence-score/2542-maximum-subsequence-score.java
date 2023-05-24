class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        
        
        int n = nums1.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        int[][] a = new int[n][2];
        
        for(int i=0;i<n;i++) a[i] = new int[]{nums1[i], nums2[i]};
        
        Arrays.sort(a, (o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        
        long sum = 0, ans = 0;
        
        for(int i = n - 1 ; i >= 0 ; i--) {
            
            if(q.size() < k - 1) {
                q.add(a[i][0]); 
                sum += a[i][0];
            }
            else {
                
                long curr = (a[i][0] + sum) * a[i][1];
                ans = Math.max(ans, curr);
                
                if(q.size() > 0 && a[i][0] > q.peek()) {
                    
                    sum -= q.remove();
                    q.add(a[i][0]);
                    sum += a[i][0];
                }
            }
        }
        
        return ans;
    }
}