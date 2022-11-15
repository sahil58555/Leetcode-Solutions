/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private ListNode listNode;
    
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head == null) {
            
            return null;
        }
     
        int size = 0;
        
        ListNode temp = head;
        listNode = head;
        
        while(temp != null) {
            
            size++;
            temp = temp.next;
        }
    
        return toBST(0,size-1);
    }
    
    private TreeNode toBST(int low,int high) {
        
        if(low > high) {
            
            return null;
        }

        int mid = (low + high + 1) >> 1;
        
        TreeNode left = toBST(low,mid-1);
        
        TreeNode treeNode = new TreeNode(listNode.val);
        
        treeNode.left = left;
        
        listNode = listNode.next;
        
        TreeNode right = toBST(mid+1,high);
        
        treeNode.right = right;
        
        return treeNode;
    }
}