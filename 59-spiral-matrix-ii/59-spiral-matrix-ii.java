class Solution {
    public int[][] generateMatrix(int n) {
     
        int[][] ans = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int direction = 0;
        int count = 1;
        
        while(top <= bottom && left <= right) {
            
            if(direction == 0) {
                
                for(int i = left ; i <= right ; i++) {
                    
                    ans[top][i] = count++;
                }
                
                top++;
            }
            else if(direction == 1) {
                
                for(int i = top ; i <= bottom ; i++) {
                    
                    ans[i][right] = count++;
                }
                
                right--;
            }
            else if(direction == 2) {
                
                for(int i = right ; i >= left ; i--) {
                    
                    ans[bottom][i] = count++;
                }
                
                bottom--;
            }
            else {
                
                for(int i = bottom ; i >= top ; i--) {
                    
                    ans[i][left] = count++;
                }
                
                left++;
            }
            
            direction = (direction + 1) % 4;
        }
        
        return ans;
    }
}