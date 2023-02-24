class Solution {
    public int minimumDeviation(int[] nums) {
     
        int n= nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        
        for(int num : nums) {
            
            if(num % 2 != 0) {
                
                num = num << 1;
            }
            
            min = Math.min(min, num);
            queue.add(num);
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        while(queue.size() > 0 && queue.peek() % 2 == 0) {
            
            int top = queue.remove();
            int currDiff = top - min;
            
            minDiff = Math.min(minDiff, currDiff);
            min = Math.min(min, top / 2);
            queue.add(top / 2);
        }
        
        minDiff = Math.min(minDiff, queue.peek() - min);
        
        return minDiff;
    }
}