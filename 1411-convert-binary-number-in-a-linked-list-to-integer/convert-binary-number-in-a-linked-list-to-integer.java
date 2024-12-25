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
    public int getDecimalValue(ListNode head) {
        head = reverse(head);
        int counter = 0;
        int sum = 0;
        while(head != null) {
            if(head.val == 1){
                sum += (int) Math.pow(2, counter);
            }
            counter++;
            head = head.next;
        }
        return sum;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            // If the list is empty or has only one element, no need to reverse
            return head;
        }

        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

}