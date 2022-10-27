class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        
        int maxOverLap = 0;
        int n = img1.length;
        
        for(int i = 1 - n ; i < n ; i++) {
            
            for(int j = 1 - n ; j < n ; j++) {
                
                int[][] shiftMatrix = shiftTheMatrix(img1,i,j);
                
                int currOverLap = getOverLapCount(shiftMatrix, img2);
                
                maxOverLap = Math.max(maxOverLap, currOverLap);
            }
        }
        
        return maxOverLap;
    }
    
    private int[][] shiftTheMatrix(int[][] mat,int x,int y) {
        
        int n = mat.length;
        int[][] shiftMatrix = new int[n][n];
        
        for(int i = 0 ; i < n ; i++) {
            
            for(int j = 0 ; j < n ; j++) {
                
                int newX = i + x;
                int newY = j + y;
                
                if(isValidCell(newX,newY,n) && mat[i][j] == 1) {
                    
                    shiftMatrix[newX][newY] = 1;
                }
            }
        }
        
        return shiftMatrix;
    }
    
    private boolean isValidCell(int x,int y,int n) {
        
        if(x < 0 || y < 0 || x >= n || y >= n) return false;
        
        return true;
    } 
    
    private int getOverLapCount(int[][] img1, int[][] img2) {
        
        int count = 0;
        int n = img1.length;
        
        for(int i = 0 ; i < n ; i++) {
            
            for(int j = 0 ; j < n ; j++) {
                
                if(img1[i][j] == 1 && img2[i][j] == 1) count++;
            }
        }
        
        return count;
    }
}