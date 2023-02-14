class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        int n = a.length();
        int m = b.length();
        
        int i = n - 1 , j = m - 1;
        int carry = 0;
        
        while(i >= 0 || j >= 0) {
            
            int bit1 = (i >= 0) ? (a.charAt(i) == '1' ? 1 : 0) : 0;
            int bit2 = (j >= 0) ? (b.charAt(j) == '1' ? 1 : 0) : 0;
            
            int sum = bit1 + bit2 + carry;
            int bit = sum % 2;
            
            sb.append(bit);
            carry = sum >= 2 ? 1 : 0;
            
            i--;
            j--;
        }
        
        if(carry == 1) {
            
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
}