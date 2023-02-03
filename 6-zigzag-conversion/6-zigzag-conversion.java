class Solution {
    public String convert(String s, int numRows) {
        
        List<char[]> list = new ArrayList<>();
        int col = numRows - 1;
        int idx = 0;
        
        while(idx < s.length()) {
            
            char[] arr = new char[numRows];
            Arrays.fill(arr, '#');
            
            if(col == 0 || col == numRows - 1) {
                
                for(int i = 0 ; i < numRows && idx < s.length() ; i++) {
                    
                    arr[i] = s.charAt(idx++);
                }
                
                col = numRows - 1;
            }
            else {
                
                arr[col] = s.charAt(idx++);
            }
            
            col = Math.max(0, col - 1);
            
            list.add(arr);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < numRows ; i++) {
            
            for(char[] arr : list) {
                
                if(arr[i] != '#') {
                    
                    sb.append(arr[i]);
                }
            }
        }
        
        return sb.toString();
    }
}