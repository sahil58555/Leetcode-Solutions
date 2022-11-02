class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Set<String> seen = new HashSet<>();
        
        if(!set.contains(end)) return -1;
        
        char[] choices = {'A', 'C', 'G', 'T'};
        
        int ans = 0;
        
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        
        while(queue.size() > 0) {
            
            int size = queue.size();
            
            for(int loop = 1 ; loop <= size ; loop++) {
                
                String front = queue.remove();
                
                if(front.equals(end)) return ans;
                
                if(seen.contains(front)) continue;
                
                seen.add(front);
                
                for(int i = 0 ; i < 8 ; i++) {
                    
                    String prefix = front.substring(0,i);
                    String suffix = front.substring(i + 1);
                    
                    for(char choice : choices) {
                        
                        String curr = prefix + choice + suffix;
                        
                        if(seen.contains(curr) == false && set.contains(curr) == true) {
                            
                            queue.add(curr);
                        }
                    }
                }
            }
            
            ans++;
        }
        
        return -1;
    }
}