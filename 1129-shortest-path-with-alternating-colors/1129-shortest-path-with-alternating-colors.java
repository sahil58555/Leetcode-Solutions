class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        int red = 0;
        int blue = 1;

        Map<Integer, List<Node>> graph = new HashMap<>();
        buildGraph(graph, redEdges, red);
        buildGraph(graph, blueEdges, blue);

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 2));

        int level = 0;
        boolean[][] visited = new boolean[n][3];

        while(queue.size() > 0) {

            int size = queue.size();

            for(int i = 1 ; i <= size ; i++) {

                Node front = queue.remove();
                int src = front.src;
                int color = front.color;

                if(visited[src][color]) {

                    continue;
                }

                visited[src][color] = true;

                if(ans[src] == -1) {

                    ans[src] = level;
                }

                for(Node neighbour : graph.getOrDefault(src, new ArrayList<>())) {

                    if(!visited[neighbour.src][neighbour.color] && color != neighbour.color) {

                        queue.add(neighbour);
                    }
                }
            }

            level++;
        }

        return ans;
    }

    private void buildGraph(Map<Integer, List<Node>> graph, int[][] edges, int color) {

        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.compute(u, (key, val) -> val == null ? new ArrayList<>() : val).add(new Node(v, color));
        }
    }
}

class Node {

    int src;
    int color;

    Node(int src, int color) {

        this.src = src;
        this.color = color;
    }
}