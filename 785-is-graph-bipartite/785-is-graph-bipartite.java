class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] value = new int[n];
        Arrays.fill(value, -1);
        
        for(int i = 0 ; i < n ; i++) {
            
            if(value[i] == -1 && isBipartite(i, graph, value, 0) == false) {
                
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isBipartite(int src, int[][] graph, int[] value, int color) {
        
        value[src] = color;
        
        for(int child : graph[src]) {
            
            if(value[child] == -1) {
                
                if(isBipartite(child, graph, value, color ^ 1) == false) {
                    
                    return false;
                }
            }
            else {
                
                if(value[child] == color) {
                    
                    return  false; 
                }
            }
        }
        
        return true;
    }
}