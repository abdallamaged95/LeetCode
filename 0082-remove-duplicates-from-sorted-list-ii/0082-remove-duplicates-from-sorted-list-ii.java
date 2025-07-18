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
public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                if (prev != null)
                    node = deleteValue(prev);
                else {
                    prev = new ListNode(Integer.MIN_VALUE, node);
                    node = deleteValue(prev);
                    if (node == null)
                        return null;
                    prev = null;
                    head = node;
                }
            }
            else {
                prev = node;
                node = node.next;
            }
        }


        return head;
    }

    public static ListNode deleteValue(ListNode head) {
        int value = head.next.val;
        ListNode node = head.next;
        while (node != null && node.val == value) {
            node = node.next;
        }
        head.next = node;
        if (head.val == Integer.MIN_VALUE)
            return node;
        return head;
    }

}