class Solution {
    
    private boolean hasTouchedBoundary;
    private int[][] directions = {
        {-1, 0}, {0, -1}, {0, 1}, {1, 0}
    };
    
    public int closedIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        
        for(int i = 0 ; i < n ; i++) {
            
            for(int j = 0 ; j < m ; j++) {
             
                if(!visited[i][j] && grid[i][j] == 0) {
                    
                    hasTouchedBoundary = false;
                    DFS(i, j, visited, grid);
                    
                    if(!hasTouchedBoundary) {
                        
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private void DFS(int row, int col, boolean[][] visited, int[][] grid) {
        
        if(row == 0 || col == 0 || row == grid.length - 1 || col == grid[0].length - 1) {
            
            hasTouchedBoundary = true;
        }
        
        visited[row][col] = true;
        
        for(int[] direction : directions) {
            
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            
            if(isValidCell(nextRow, nextCol, visited, grid)) {
                
                DFS(nextRow, nextCol, visited, grid);
            }
        }
    } 
    
    private boolean isValidCell(int row, int col, boolean[][] visited, int[][] grid) {
        
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length|| visited[row][col] || grid[row][col] == 1) {
            
            return false;
        }
        
        return true; 
    }
}