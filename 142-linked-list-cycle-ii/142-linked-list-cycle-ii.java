/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
     
        if(head==null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        boolean containsCycle = false;
        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow==fast)
            {
                containsCycle = true;
                break;
            }
                
        }
        
        if(!containsCycle)
            return null;
        
        slow = head;
        
        while(slow!=fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}