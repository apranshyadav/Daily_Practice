public class rev_linkedlist {
    /**
 * Definition for singly-linked list.
 */
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null; // This will eventually be the new head.
            ListNode current = head; // Start at the beginning of the list.
            ListNode nextTemp = null; // Temporarily store the next node.

            while (current != null) {
                nextTemp = current.next; // Store the next node before we overwrite it.
                current.next = prev;     // Reverse the pointer of the current node.
                prev = current;          // Move the 'prev' pointer one step forward.
                current = nextTemp;      // Move the 'current' pointer one step forward.
            }

        // 'prev' is now pointing to the last node of the original list, which is the new head.
        return prev;
        }
    }
}
