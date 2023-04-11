class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Node> stack = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            
            if(stack.size() == 0 || stack.peek().ch != ch) {
                
                stack.push(new Node(ch, 1));
            }
            else {
                
                stack.push(new Node(ch, stack.peek().freq + 1));
            }
            
            if(stack.peek().freq == k) {
                
                for(int i = 1 ; i <= k ; i++) {
                    
                    stack.pop();
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(Node node : stack) {
            sb.append(node.ch);
        }
        
        return sb.toString();
    }
}

class Node {
    
    char ch;
    int freq;
    
    Node(char ch, int freq) {
        
        this.ch = ch;
        this.freq = freq;
    }
}