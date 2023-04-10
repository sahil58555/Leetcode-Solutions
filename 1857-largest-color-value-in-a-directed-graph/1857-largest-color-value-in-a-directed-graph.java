class Solution {
    
    private Map<Integer, List<Integer>> graph;
    private String colors;
    private int n;
    
    public int largestPathValue(String colors, int[][] edges) {
        
        this.colors = colors;
        this.n = colors.length();
        
        buildGraph(edges);
        
        if(isCycle()) {
            
            return -1;
        }
        
        int longestPath = 0;
        
        for(char color = 'a' ; color <= 'z' ; color++) {
            
            int currLongestPath = findLargestColorValuePath(color);
            longestPath = Math.max(longestPath, currLongestPath);
        }
        
        return longestPath;
    }
    
    private int findLargestColorValuePath(char color) {
        
        Integer[] cache = new Integer[n];
        int longestPath = 0;
        
        for(int i = 0 ; i < n ; i++) {
            
            if(cache[i] == null) {
                
                longestPath = Math.max(DFS(i, cache, color), longestPath);
            }
        }
        
        return longestPath;
    }
    
    private int DFS(int src, Integer[] cache, char color) {
        
        if(cache[src] != null) {
            
            return cache[src];
        }
        
        int longestPath = 0;
        
        for(int ngbr : graph.get(src)) {
            
            longestPath = Math.max(longestPath, DFS(ngbr, cache, color));
        }
        
        if(colors.charAt(src) == color) {
            
            longestPath++;
        }
        
        return cache[src] = longestPath;
    }
    
    private void buildGraph(int[][] edges) {
        
        graph = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++) {
            
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
        }
        
    }
    
    private boolean isCycle() {
        
        boolean[] visited = new boolean[n];
        
        for(int i = 0 ; i < n ; i++) {
            
            if(!visited[i]) {
                
                if(isCycle(i, visited, new HashSet<Integer>())) {
                    
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isCycle(int src, boolean[] visited, Set<Integer> path) {
        
        path.add(src);
        visited[src] = true;
        
        for(int ngbr : graph.get(src)) {
            
            if(path.contains(ngbr) || (visited[ngbr] == false && isCycle(ngbr, visited, path))) {
                
                return true;
            }
        }
        
        path.remove(src);
        return false;
    }
}