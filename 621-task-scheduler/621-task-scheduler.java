class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] time = new int[26];
        int[] freq = new int[26];
        
        for(char task : tasks) {
            
            freq[task - 'A']++;
        }
        
        int currDay = 0;
        int count = 0;
        
        while(count < tasks.length) {
            
            int max = -1;
            int index = -1;
            
            for(char task = 'A' ; task <= 'Z' ; task++) {
                
                if(currDay >= time[task - 'A'] && freq[task - 'A'] > 0) {
                    
                    if(freq[task - 'A'] > max) {
                        
                        index = task - 'A';
                        max = freq[task - 'A'];
                    }
                    
                } 
            }
            
            if(index != -1) {
                
                
                freq[index]--;
                count++;
                time[index] = n + currDay + 1;
            }
            
            currDay++;
        }
        
        return currDay;
    }
}