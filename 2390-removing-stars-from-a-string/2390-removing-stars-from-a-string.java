class Solution {
    public String removeStars(String s) {
        
        int n = s.length();
        boolean[] v = new boolean[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++) {
            
            char ch = s.charAt(i);
            
            if(ch == '*') {
                
                v[st.pop()] = true;
                v[i] = true;
            }
            else{
                
                st.push(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<n;i++) {
            
            if(!v[i]) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}