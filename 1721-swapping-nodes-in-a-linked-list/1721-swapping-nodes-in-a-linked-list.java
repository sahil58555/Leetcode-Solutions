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
    public ListNode swapNodes(ListNode head, int k) {
     
        int count = 1;
        ListNode curr = head;
        ListNode firstNode = head,secondNode = head;
        
        while(curr.next!=null)
        {
            if(count==k)
            {
                firstNode = curr;
                secondNode = head;
            }
            
            count++;
            curr = curr.next;
            secondNode = secondNode.next;
        }
        
        swap(firstNode,secondNode);
        
        return head;
    }
    
    private void swap(ListNode node1,ListNode node2)
    {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}