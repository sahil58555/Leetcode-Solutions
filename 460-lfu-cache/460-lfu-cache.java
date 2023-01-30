class LFUCache {
    
    private final int capacity;
    private final Map<Integer, DLLNode> cache;
    private final Map<Integer, DoubleLinkedList> freqList;
    private int minFreq;
    
    public LFUCache(int capacity) {
        
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqList = new HashMap<>();
        this.minFreq = 0;
    }
    
    public int get(int key) {
        
        if(!cache.containsKey(key)) {
            
            return -1;
        }
        
        DLLNode node = cache.get(key);
        DoubleLinkedList list = freqList.get(node.freq);
        //System.out.println(key);
        list.deleteDLLNode(node);
        
        if(minFreq == node.freq && list.size == 0) {
            
            minFreq++;
        }
        
        node.freq++;
        
        DoubleLinkedList newList = freqList.getOrDefault(node.freq, new DoubleLinkedList());
        newList.addDLLNode(node);
        freqList.put(node.freq, newList);
        
        return cache.get(key).value;
    }
    
    public void put(int key, int value) {
        
        if(capacity == 0) return ;
        
        if(cache.containsKey(key)) {
            
            DLLNode node = cache.get(key);
            node.value = value;
            DoubleLinkedList list = freqList.get(node.freq);
            list.deleteDLLNode(node);
            
            if(minFreq == node.freq && list.size == 0) {
            
                minFreq++;
            }

            node.freq++;

            DoubleLinkedList newList = freqList.getOrDefault(node.freq, new DoubleLinkedList());
            newList.addDLLNode(node);
            freqList.put(node.freq, newList);
            
        }
        else {
         
            if(cache.size() == capacity) {
             
                DoubleLinkedList list = freqList.get(minFreq);
                DLLNode lastNode = list.tail.prev;
                list.deleteDLLNode(lastNode);
                cache.remove(lastNode.key);
            }
            
            DLLNode node = new DLLNode(key, value);
            DoubleLinkedList list = freqList.getOrDefault(1, new DoubleLinkedList());
            list.addDLLNode(node);
            cache.put(key, node);
            freqList.put(1, list);
            
            minFreq = 1;
            
        }
    }
}

class DLLNode {
    
    int key;
    int value;
    int freq;
    DLLNode prev;
    DLLNode next;
    
    DLLNode(int key, int value) {
        
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoubleLinkedList {
    
    DLLNode head;
    DLLNode tail;
    int size;
    
    DoubleLinkedList() {
        
        head = new DLLNode(-1, 0);
        tail = new DLLNode(-1, 0);
        size = 0;
        
        head.next = tail;
        tail.prev = head;
    }
    
    void addDLLNode(DLLNode node) {
     
        size++;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        
    }
    
    void deleteDLLNode(DLLNode node) {

        size--;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
