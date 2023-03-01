class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int longestIncPath = 0;
        
        Integer[][] dp = new Integer[n][m];
        
        for(int i = 0 ; i < n ; i++) {
            
            for(int j = 0 ; j < m ; j++) {
                
                int currLongestIncPath = DFS(matrix, i, j, dp);
                longestIncPath = Math.max(longestIncPath, currLongestIncPath);
            }
        }
        
        return longestIncPath;
    }
    
    private int DFS(int[][] matrix, int row, int col, Integer[][] dp) {
        
        if(dp[row][col] != null) {
            
            return dp[row][col];
        }
        
        int[][] directions = {
            {-1, 0}, {0, -1}, {0, 1}, {1, 0}
        };
        
        int maxLen = 0;
        
        for(int[] direction : directions) {
            
            int nextRow = direction[0] + row;
            int nextCol = direction[1] + col;
            
            if(isInBoundary(matrix, nextRow, nextCol) && matrix[row][col] < matrix[nextRow][nextCol]) {
                
                maxLen = Math.max(maxLen, DFS(matrix, nextRow, nextCol, dp));
            }
        }
        
        return dp[row][col] = maxLen + 1;
    }
    
    private boolean isInBoundary(int[][] matrix, int row, int col) {
        
        if(row < 0 || col < 0 || row == matrix.length || col == matrix[0].length) {
            
            return false;
        }
        
        return true;
    }
}