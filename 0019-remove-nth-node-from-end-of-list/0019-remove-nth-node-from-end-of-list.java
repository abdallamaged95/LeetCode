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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        idx = n;
        return solve(head, null);
    }
    public static ListNode solve(ListNode node, ListNode parent) {
        if (node.next != null) {
            solve(node.next, node);
            idx -= 1;
        }
        if (idx == 1) {
            if (parent != null) {
                parent.next = node.next;
                node.next = null;
            }
            else {
                parent = node.next;
                node.next = null;
            }
            return parent;
        }
        return node;
        
    }
}