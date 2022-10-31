class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
     
        int row,col;
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(row = 0 , col = 0 ; col < m ; col++) {
            
            if(isDiagonalElementsSame(matrix,row,col) == false) {
                
                return false;
            }
        }
        
        for(row = 0 , col = 0 ; row < n ; row++) {
            
            if(isDiagonalElementsSame(matrix,row,col) == false) {
                
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isDiagonalElementsSame(int[][] matrix, int row, int col) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int val = matrix[row][col];
        
        while(row < n && col < m) {
            
            if(matrix[row][col] != val) return false;
            
            row++;
            col++;
        }
        
        return true;
    }
}