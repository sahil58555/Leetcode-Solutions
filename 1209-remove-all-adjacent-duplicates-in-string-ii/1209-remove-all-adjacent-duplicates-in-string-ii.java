class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Node> stack = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            
            if(stack.size() == 0 || stack.peek().ch != ch) {
                
                stack.push(new Node(ch, 1));
            }
            else {
                
                stack.peek().freq++;
            }
            
            if(stack.peek().freq == k) {
                
                stack.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(Node node : stack) {
            
            sb.append((node.ch + "").repeat(node.freq));
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