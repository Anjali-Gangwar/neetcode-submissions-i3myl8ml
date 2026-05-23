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
    public void reorderList(ListNode head) {

        if(head == null || head.next == null) {
            return;
        }

        // STEP 1: Find middle
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // STEP 2: Split list
        ListNode second = slow.next;
        slow.next = null;

        // STEP 3: Reverse second half
        ListNode prev = null;
        ListNode curr = second;

        while(curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        second = prev;

        // STEP 4: Merge both halves
        ListNode first = head;

        while(second != null) {

            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }
}
