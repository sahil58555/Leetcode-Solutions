class Solution {
    public int diagonalSum(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        int row = 0;
        int colLeft = 0;
        int colRight = m - 1;
        int sum = 0;
        
        while(row < n) {
            
            sum += mat[row][colLeft];
            
            if(colLeft != colRight) {
                
                sum += mat[row][colRight];
            }
            
            row++;
            colLeft++;
            colRight--;
        }
        
        return sum;
    }
}