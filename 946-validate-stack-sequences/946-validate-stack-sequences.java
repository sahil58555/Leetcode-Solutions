class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> st=new Stack<>();
        int first = 0 , second = 0;
        int n = pushed.length;
        
        while(first < n) {
            
            st.push(pushed[first++]);
            
            while(st.size() > 0 && st.peek() == popped[second]) {
                
                st.pop();
                second++;
            }
        }
        
        return st.isEmpty();
    }
}