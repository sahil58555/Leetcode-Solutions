class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int n = profits.length;
        
        Pair[] pairs = new Pair[n];
        
        for(int i = 0 ; i < n ; i++) {
            
            pairs[i] = new Pair(profits[i], capital[i]);
        }
        
        Arrays.sort(pairs, (pair1, pair2) -> Integer.compare(pair1.capital, pair2.capital));
        
        int count = 0;
        int currCapital = w;
        int idx = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>((pair1, pair2) -> -1 * Integer.compare(pair1.profit, pair2.profit));
        
        while(count < k) {
            
            count++;
            
            while(idx < n && pairs[idx].capital <= currCapital) {
                
                queue.add(pairs[idx]);
                idx++;
            }   
            
            if(queue.isEmpty()) {
                
                break;
            }
            
            currCapital += queue.remove().profit;
        }
        
        return currCapital;
    }
}

class Pair {
    
    int profit;
    int capital;
    
    Pair(int profit, int capital) {
        
        this.profit = profit;
        this.capital = capital;
    }
}