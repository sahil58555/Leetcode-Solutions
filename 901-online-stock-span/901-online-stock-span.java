class StockSpanner {
    
    Stack<Pair> st;
    int count;
    public StockSpanner() {
        
         st=new Stack<>();
        count=0;
    }
    
    public int next(int price) {
        
        count++;
        int ans=1;
        
        if(st.size()==0)
        {
            st.push(new Pair(price,count));
        }
        else
        {
            while(st.size()>0 && price>=st.peek().val)
                st.pop();
            
           
            ans=count-((st.size()==0)?0:st.peek().idx);
            st.push(new Pair(price,count));
        }
        
        return ans;
    }
}
class Pair
{
    int val;
    int idx;
    
    Pair(int val , int idx)
    {
        this.val=val;
        this.idx=idx;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */