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
    public static int idx;
    public static int x = 0;
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        idx = n;
        x = 0;
        solve(head);
        if (x == n)
            return head.next;
        return head;
    }
    public static void solve(ListNode node) {
        if (node == null){
            return;
        }
        solve(node.next);
        x += 1;
        if (x == idx+1) {
            node.next = node.next.next;
        }
    }
}