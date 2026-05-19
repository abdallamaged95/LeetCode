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
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        ListNode fast = head, slow = head;
        ListNode prev = null, tmp = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            tmp = slow;
            slow = slow.next;
            tmp.next = prev;
            prev = tmp;
        }
        boolean flag = (fast.next != null);
        tmp = slow;
        slow = slow.next;
        tmp.next = prev;
        if (flag)
            prev = tmp;
        while (slow != null && prev != null) {
            if (slow.val != prev.val)
                return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
        //
    }
}