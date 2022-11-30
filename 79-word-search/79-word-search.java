class Solution {
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0 ; i < n ; i++) {
            
            for(int j = 0 ; j < m ; j++) {
                
                if(DFS(i, j, 0, board, word)) {
                    
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean DFS(int row, int col, int idx, char[][] board, String word) {
        
        if(idx == word.length()) {
            
            return true;
        }
        
        if(row < 0 || col < 0 || row == board.length || col == board[0].length || board[row][col] != word.charAt(idx)) {
            
            return false;
        }
        
        board[row][col] = '.';
        
        int[][] dirs = {
            
            {-1, 0}, {0, -1}, {0, 1}, {1, 0}
        };
        
        for(int[] dir : dirs) {
            
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if(DFS(nextRow, nextCol, idx + 1, board, word)) {
                
                return true;
            }
        }
        
        board[row][col] = word.charAt(idx);
        
        return false;
    }
}