class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        Trie t = new Trie();
        List<String> list = new ArrayList<>();
        
        for(String word : words)
            t.insert(word);
        
        t.Solver(board,list);
        
        return list;
    }
}
class Trie 
{
      class Node
        {
            Node[] child=new Node[26];
            boolean isEnd=false;
            String str="";
            boolean flag=false; 
        }


    Node root=null;
    
    Trie()
    {
        root=new Node();
    }
    
    public void Solver(char[][] board,List<String> list)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                DFS(board,i,j,list,root);    
            }
        }     
    }
    
    public void DFS(char[][] board,int i,int j,List<String> list,Node node)
    {
        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j]=='0')
            return;
        
        char ch = board[i][j];

        if(node.child[ch-'a']==null)
            return;
        
        Node curr = node.child[ch-'a'];
        
        if(curr.isEnd)
        {
            if(!curr.flag)
            {
                list.add(curr.str);
                curr.flag=true;
            }
        }
        
        board[i][j]='0';
        
         DFS(board,i-1,j,list,curr);
         DFS(board,i,j+1,list,curr);
         DFS(board,i+1,j,list,curr);
         DFS(board,i,j-1,list,curr);
        
        board[i][j]=ch;
        
    }
    
    public void insert (String str)
    {
        Node curr=root;
        
        for(char ch : str.toCharArray())
        {
            
            if(curr.child[ch-'a']==null)
            curr.child[ch-'a']=new Node();
            
            curr=curr.child[ch-'a'];
        }
        
        curr.isEnd=true;
        curr.str=str;
    }
       
}