class Solution {
    
    private Map<Integer, List<Integer>> index;
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        createIndexMap(nums2);
        
        Integer[][] dp = new Integer[nums1.length][nums2.length + 1];
        
        return sol(0, 0, nums1, nums2, dp);
    }
    
    private void createIndexMap(int[] nums) {
        
        index = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++) {
            
            index.compute(nums[i], (key, val) -> val == null ? new ArrayList<>() : val).add(i);
        }
    }
    
    private int sol(int idx, int maxIdx, int[] nums1, int[] nums2, Integer[][] dp) {
        
        if(idx == nums1.length) {
            
            return 0;
        }
        
        if(dp[idx][maxIdx] != null) {
            
            return dp[idx][maxIdx];
        }
        
        int notTake = sol(idx + 1, maxIdx, nums1, nums2, dp);
        
        List<Integer> listIndex = index.getOrDefault(nums1[idx], new ArrayList<>());
        int eleIndex = Collections.binarySearch(listIndex, maxIdx);
        
        if(eleIndex < 0) {
            
            eleIndex = eleIndex * -1 - 1;
        }

        int take = 0;
        
        if(eleIndex < listIndex.size()) {
            
            take = 1 + sol(idx + 1, listIndex.get(eleIndex) + 1, nums1, nums2, dp);
        }
        
        return dp[idx][maxIdx] = Math.max(notTake, take);
    }
}