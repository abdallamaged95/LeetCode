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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode curr = head.next;
        ListNode prev = head;
        while (curr != null) {
            while (curr != null && curr.val == prev.val)
                curr = curr.next;
            prev.next = curr;
            if (curr == null)
                break;
            curr = curr.next;
            prev = prev.next;
        }
        return head;
    }
}