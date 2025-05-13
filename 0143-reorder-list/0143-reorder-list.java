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
        public static ListNode head1;
    public static void reorderList(ListNode head) {
        head1 = head;
        ListNode p1 = head, p2 = head.next, head2;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        head2 = p1.next;
        p1.next = null;
        solve(head2);
    }
    public static void solve(ListNode node) {
        if (node != null){
            solve(node.next);
            ListNode tmp = head1.next;
            head1.next = node;
            node.next = tmp;
            head1 = tmp;
        }
    }
}