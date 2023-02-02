class BrowserHistory {

    private final ArrayList<String> urls;
    private int curr;
    private int size;
    
    public BrowserHistory(String homepage) {
        
        urls = new ArrayList<>();
        urls.add(homepage);
        curr = 0;
        size = 1;
    }
    
    public void visit(String url) {
        
        int index = curr + 1;
        
        if(index < urls.size()) {
            
            urls.set(index, url);
        }
        else {
            
            urls.add(url);
        }
        
        curr++;
        size = curr + 1;
    }
    
    public String back(int steps) {
        
        int index = Math.max(curr - steps, 0);
        curr = index;
        
        return urls.get(curr);
    }
    
    public String forward(int steps) {
        
        int index = Math.min(size - 1, curr + steps);
        curr = index;
        
        return urls.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */