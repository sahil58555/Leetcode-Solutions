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
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        
        ListNode myHead = null;
        ListNode prev = null;
        
        ListNode temp = head;
        
        while(temp!=null && temp.next!=null)
        {
            ListNode node1 = temp;
            ListNode node2 = temp.next;
            
            node1.next = node2.next;
            node2.next = node1;
            
            if(prev!=null)
            prev.next = node2;
            
            if(myHead==null)
                myHead = node2;
            
            prev = node1;
            temp = node1.next;
        }
     
        return myHead;
    }
}