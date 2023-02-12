class Solution {
    
    long ans;
    
    public long minimumFuelCost(int[][] roads, int seats) {
        
        int n = roads.length;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        for(int i = 0 ; i <= n ; i++) graph.put(i, new ArrayList<>());
        
        for(int[] road : roads) {
            
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        ans = 0;
        find(0, graph, -1, seats);
        
        return ans;
    }
    
    private int find(int src, Map<Integer,List<Integer>> graph, int prev, int seats) {
        
        int count = 1;
        
        for(int child : graph.get(src)) {
            
            if(child != prev) {
                
                count += find(child, graph, src, seats);
            }
        }
        
        if(src != 0) {
            
            ans += (long)(Math.ceil(1.0 * count / seats));
        }
        
        return count;
    }
}