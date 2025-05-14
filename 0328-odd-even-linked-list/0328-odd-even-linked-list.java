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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode even = head, odd = head.next, p = head.next.next;
        ListNode oddClone = odd;
        boolean flag = true;
        odd.next = even.next = null;
        while (p != null) {
            if (flag) {
                even.next = p;
                even = even.next;
                p = p.next;
                even.next = null;
            }
            else {
                odd.next = p;
                odd = odd.next;
                p = p.next;
                odd.next = null;
            }
            // p = p.next;
            flag = !flag;
        }
        even.next = oddClone;
        return head;
    }
}