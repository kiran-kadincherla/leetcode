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
    public ListNode reverseBetween(ListNode head, int left, int right) {
          if(head.next != null && left != right){
            ListNode current = head;
            ListNode prev = null;
            ListNode next = null;

            int k = left;
            while(k > 1 ){
                prev = current;
                current = current.next;
                k--;
            }
            k = right-left;
            ListNode tempPrev = null;
            while(k >= 0 ){
                next = current.next;
                current.next = tempPrev;
                tempPrev = current;
                current = next;
                k--;
            }
            ListNode tempHead = tempPrev;
            while(tempPrev.next != null){
                tempPrev = tempPrev.next;
            }
            tempPrev.next = next;
            if(prev != null) {
                // ListNode dummyHead = head;
                // while(dummyHead.val != prev.val) {
                //     dummyHead = dummyHead.next;
                // }
                // dummyHead.next = tempHead;
                prev.next = tempHead;
                return head;
            } else {
                return tempHead;
            }
            
        }
        return head;
    }
}