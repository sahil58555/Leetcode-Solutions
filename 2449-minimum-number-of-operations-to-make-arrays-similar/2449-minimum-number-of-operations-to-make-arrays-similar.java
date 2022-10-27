class Solution {
    public long makeSimilar(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);
        
        long sum = sol(a,b,0) + sol(a,b,1);
        
        return sum;
    }
    
    private long sol(int[] a,int[] b,int parity) {
        
        int n = a.length;
        long ans = 0;
        int i = 0 , j = 0;
        
        while(i < n) {
            
            while(i < n && a[i] % 2 != parity) i++;
            while(j < n && b[j] % 2 != parity) j++;
            
            if(i == n) break;
            
            if(a[i] > b[j]) ans += a[i] - b[j];
            
            i++;
            j++;
        }
        
        return ans / 2;
    }
}