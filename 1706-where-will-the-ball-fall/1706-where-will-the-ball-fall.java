class Solution {
    public int[] findBall(int[][] grid) {
        
        int m = grid[0].length;
        int[] ans = new int[m];
        
        for(int row = 0, col = 0 ; col < m ; col++) {
            
            ans[col] = findBall(grid, row, col);
        }
        
        return ans;
    }
    
    private int findBall(int[][] grid, int row, int col) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        while(row < n) {
            
            int span = grid[row][col];
            
            if(span == 1) {
                
                if(col == m - 1 || grid[row][col + 1] == -1) return -1;
                
                row++;
                col++;
            }
            else{
                
                if(col == 0 || grid[row][col - 1] == 1) return -1;
                
                row++;
                col--;
            }
        }
        
        return col;
    }
}