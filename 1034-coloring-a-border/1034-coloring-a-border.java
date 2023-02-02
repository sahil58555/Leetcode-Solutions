class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
     
        int n = grid.length;
        int m = grid[0].length;
        
        DFS(grid, row, col, color);
        updateMatrix(grid);
        
        return grid;
    }
    
    private void DFS(int[][] grid, int row, int col, int color) {
        
        int temp = grid[row][col];
        grid[row][col] = -color;
        int count = 0;
        
        int[][] directions = {
            {-1, 0}, {0, -1}, {1, 0}, {0, 1}
        };
        
        for(int[] direction : directions) {
            
            int nextRow = direction[0] + row;
            int nextCol = direction[1] + col;
            
            if(isValidCell(grid, nextRow, nextCol)) {
                
                if(grid[nextRow][nextCol] > 0) {
                    
                    if(grid[nextRow][nextCol] == temp) {
                        
                        count++;
                        DFS(grid, nextRow, nextCol, color);
                    }
                }
                else {
                    
                    count++;
                }
            }
        }
        
        if(count == 4) {
            
            grid[row][col] = -1 * temp;
        }
    }
    
    private boolean isValidCell(int[][] grid, int row, int col) {
        
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length) {
            
            return false;
        }
        
        return true;
    }
    
    private void updateMatrix(int[][] grid) {
        
        for(int[] row : grid) {
            
            for(int col = 0 ; col < row.length ; col++) {
                
                if(row[col] < 0) {
                    
                    row[col] *= -1;
                }
            }
        }
    }
}