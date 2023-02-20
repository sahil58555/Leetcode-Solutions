class ZeroEvenOdd {
    private int n;
    private int currState;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.currState = 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        
        for(int i = 1 ; i <= n ; i++) {
            
            synchronized(this) {
                
                while(currState != 0) {
                    
                    wait();
                }
                
                printNumber.accept(0);
                
                if(i % 2 == 1) {
                    
                    currState = 1;
                }
                else {
                    
                    currState = 2;
                }
                
                notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        
        for(int i = 2 ; i <= n ; i += 2) {
            
            synchronized(this) {
                
                while(currState != 2) {
                    
                    wait();
                }
                
                printNumber.accept(i);
                
                currState = 0;
                
                notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        
        for(int i = 1 ; i <= n ; i += 2) {
            
            synchronized(this) {
                
                while(currState != 1) {
                    
                    wait();
                }
                
                printNumber.accept(i);
                
                currState = 0;
                
                notifyAll();
            }
        }
    }
}