class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        Map<Integer,int[]> map = new HashMap<>();
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int[] match : matches)
        {
            int winner = match[0];
            int losser = match[1];
            
            map.putIfAbsent(winner,new int[2]);
            map.putIfAbsent(losser,new int[2]);
            
            map.get(winner)[0]++;
            map.get(losser)[1]++;
        }
        
        for(int player : map.keySet())
        {
            int[] result = map.get(player);
            
            if(result[0]>0 && result[1]==0)
                list1.add(player);
            
            if(result[1]==1)
                list2.add(player);
        }
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        ans.add(list1);
        ans.add(list2);
        
        return ans;
    }
}