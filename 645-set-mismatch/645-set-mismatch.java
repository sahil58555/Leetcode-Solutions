class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int xor = 0;
        int idx = 1;
        
        for(int num : nums) {
            
            xor = xor ^ num;
            xor = xor ^ idx;
            
            idx++;
        }
        
        //System.out.println(xor);
        
        int num1 = 0 , num2 = 0;
        int mask = xor & (~xor + 1);
        
        idx = 1;
        
        for(int num : nums) {
            
            if((mask & num) == 0) {
                
                num1 = num1 ^ num;
            }
            else{
                
                num2 = num2 ^ num;
            }
            
            if((mask & idx) == 0) {
                
                num1 = num1 ^ idx;
            }
            else{
                
                num2 = num2 ^ idx;
            }
            
            idx++;
        }
        
        for(int num : nums) {
            
            if(num == num1) {
                
                return new int[]{num1,num2};
            }
            else if(num == num2) {
                
                return new int[]{num2,num1};
            }
        }
        
        return null;
    }
}