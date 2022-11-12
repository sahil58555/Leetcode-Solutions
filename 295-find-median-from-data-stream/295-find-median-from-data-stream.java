class MedianFinder {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        
        if(maxHeap.size()==0)
        {
            maxHeap.add(num);
            return;
        }
        
        if(maxHeap.size()==minHeap.size())
        {
            if(num>minHeap.peek())
            {
                maxHeap.add(minHeap.remove());
                minHeap.add(num);
            }
            else
            {
                maxHeap.add(num);
            }
        }
        else
        {
            if(num<maxHeap.peek())
            {
                minHeap.add(maxHeap.remove());
                maxHeap.add(num);
            }
            else
            {
                minHeap.add(num);
            }
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