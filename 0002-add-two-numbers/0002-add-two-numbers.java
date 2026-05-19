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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = l2;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            l2.val = sum;
            if (l1.next == null || l2.next == null)
                break;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1.next == null && l2.next == null) {
            if (carry > 0)
                l2.next = new ListNode(carry);
        }
        else if (l1.next == null && l2.next != null) {
            l2 = l2.next;
            while (carry > 0 && l2 != null) {
                int sum = l2.val + carry;
                carry = sum / 10;
                sum = sum % 10;
                l2.val = sum;
                if (l2.next == null && carry > 0) {
                    l2.next = new ListNode(carry);
                    break;
                }
                l2 = l2.next;
            }
        }
        else if (l1.next != null && l2.next == null) {
            l2.next = l1.next;
            l2 = l2.next;
            while (carry > 0 && l2 != null) {
                int sum = l2.val + carry;
                carry = sum / 10;
                sum = sum % 10;
                l2.val = sum;
                if (l2.next == null && carry > 0) {
                    l2.next = new ListNode(carry);
                    break;
                }
                l2 = l2.next;
            }
        }
        return head;
    }
}