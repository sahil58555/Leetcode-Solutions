class KthLargest {

    private PriorityQueue<Integer> queue;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        
        queue = new PriorityQueue<>();
        this.k = k;
        
        for(int num : nums) {
            
            addInPriorityQueue(num);
        }
        
    }
    
    public int add(int num) {
        
        addInPriorityQueue(num);
        
        return queue.peek();
    }
    
    private void addInPriorityQueue(int num) {
        
        if(queue.size() < k) {
                
            queue.add(num);
        }
        else {
                
            if(num > queue.peek()) {
                    
                queue.remove();
                queue.add(num);
            }
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */