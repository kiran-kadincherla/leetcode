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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null; 

        for(int i=1;i<=n;i++){
            fast = fast.next;
        }
        //System.out.print("fast "+fast.val+ " slow "+slow.val);

        while(fast!=null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        

        if(prev != null) {
            if(slow !=null){
            prev.next = slow.next;
            }
            return head;
        } else {
            if(slow != null){
                return slow.next;
            }
            return null;
        }
        
    }
}