class Solution {
    public int[][] outerTrees(int[][] trees) {
        
        int n = trees.length;
        
        Arrays.sort(trees, (tree1, tree2) -> {
            
            if(tree1[0] == tree2[0]) return Integer.compare(tree1[1], tree2[1]);
            
            return Integer.compare(tree1[0], tree2[0]);
        });
        
        List<Integer> list = new ArrayList<>();
        
        // lower hull
        for(int i = 0 ; i < n ; i++) {
            
            while(list.size() > 1 && orientation(list.get(list.size() - 2), list.get(list.size() - 1), i, trees) < 0) {
                
                list.remove(list.size() - 1);
            }
            
            list.add(i);
        }
        
        // upper hull
        for(int i = n - 2 ; i >= 0 ; i--) {
            
            while(list.size() > 1 && orientation(list.get(list.size() - 2), list.get(list.size() - 1), i, trees) < 0) {
                
                list.remove(list.size() - 1);
            }
        
            list.add(i);
        }
        
        Set<Integer> set = new HashSet<>(list); // to remove duplicates 
        
        int[][] ans = new int[set.size()][2];
        int i = 0;
        
        for(int idx : set) {
            
            ans[i][0] = trees[idx][0];
            ans[i][1] = trees[idx][1];
            
            i++;
        }
        
        return ans;
    }
    
    private int orientation (int idx1, int idx2, int idx3, int[][] trees) {
        
        int[] p = trees[idx1], q = trees[idx2], r = trees[idx3];
        
        return ((r[1] - q[1]) * (q[0] - p[0])) - ((q[1] - p[1]) * (r[0] - q[0]));
    }
}