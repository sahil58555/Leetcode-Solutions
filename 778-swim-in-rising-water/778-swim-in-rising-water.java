class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((cell1, cell2) -> {
            
            return Integer.compare(cell1[2], cell2[2]);
        });
        
        queue.add(new int[]{0,0,grid[0][0]});
        
        boolean[][] visited = new boolean[n][m];
        
        int[][] dirs = {
            {-1,0},{0,-1},{0,1},{1,0}
        };
        
        while(queue.size() > 0) {
            
            int[] front = queue.remove();
            
            int row = front[0];
            int col = front[1];
            int currVal = front[2];
            
            if(row == n - 1 && col == m - 1) {
                
                return currVal;
            }
            
            if(visited[row][col]) {
                
                continue;
            }
            
            visited[row][col] = true;
            
            for(int[] dir : dirs) {
                
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                
                if(isValidCell(nextRow,nextCol,visited)) {
                    
                    queue.add(new int[]{nextRow, nextCol, Math.max(currVal, grid[nextRow][nextCol])});
                }
            }
        }
        
        return -1;
    }
    
    private boolean isValidCell(int row, int col, boolean[][] visited) {
        
        if(row < 0 || col < 0 || row == visited.length || col == visited[0].length || visited[row][col]) {
            
            return false;
        }
        
        return true;
    }
}