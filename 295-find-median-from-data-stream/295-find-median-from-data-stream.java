class MedianFinder {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        
        if(maxHeap.size() == 0 || num <= maxHeap.peek()) {
            
            maxHeap.add(num);
        }
        else {
            
            minHeap.add(num);
        }
        
        if(maxHeap.size() == minHeap.size() + 2) {
            
            minHeap.add(maxHeap.remove());
        }
        else if(maxHeap.size() + 1 == minHeap.size()) {
            
            maxHeap.add(minHeap.remove());
        }
        
    }
    
    public double findMedian() {
        
        if(maxHeap.size()==minHeap.size())
        {
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
        
        return maxHeap.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */