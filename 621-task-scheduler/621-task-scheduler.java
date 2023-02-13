class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq = new int[26];
        
        for(char task : tasks) {
            
            freq[task - 'A']++;
        }
        
        Arrays.sort(freq);
        
        int ideal = (freq[25] - 1) * n;
        
        for(int i = 0 ; i < 25 ; i++) {
            
            ideal -= Math.min(freq[i], freq[25] - 1);
        }
        
        return tasks.length + Math.max(0, ideal);
    }
}