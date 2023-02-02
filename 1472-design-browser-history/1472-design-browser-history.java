class BrowserHistory {

    private Node curr;
    
    public BrowserHistory(String homepage) {
        
        curr = new Node(homepage);
    }
    
    public void visit(String url) {
        
        Node next = new Node(url);
        curr.next = next;
        next.prev = curr;
        curr = curr.next;
    }
    
    public String back(int steps) {
        
        while(steps > 0 && curr.prev != null) {
            
            steps--;
            curr = curr.prev;
        }
        
        return curr.url;
    }
    
    public String forward(int steps) {
     
        while(steps > 0 && curr.next != null) {
            
            steps--;
            curr = curr.next;
        }
        
        return curr.url;
    }
}

class Node {
    
    String url;
    Node prev;
    Node next;
    
    Node(String url) {
        
        this.url = url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */