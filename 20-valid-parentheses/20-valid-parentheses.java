class Solution {
    public boolean isValid(String s) {
        
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);   
            }
            else if(ch == ')') {
                
                if(stack.size() == 0 || stack.pop() != '(') {
                    
                    return false;
                }
            }
            else if(ch == '}') {
                
                if(stack.size() == 0 || stack.pop() != '{') {
                    
                    return false;
                }
            }
            else {
                
                if(stack.size() == 0 || stack.pop() != '[') {
                    
                    return false;
                }
            }
        }
        
        return stack.size() == 0;
    }
}