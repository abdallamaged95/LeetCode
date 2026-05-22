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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        ListNode lnode = new ListNode(0,head), rnode = lnode, prevLeft = null, prev = null;
        right += 1;
        left += 1;
        while (right > 1) {
            if (left > 1) {
                if (left == 2)
                    prevLeft = lnode;
                lnode = lnode.next;
                left -= 1;
                rnode = rnode.next;
            }
            else {
                ListNode tmp = rnode;
                rnode = rnode.next;
                tmp.next = prev;
                prev = tmp;
            }
            right -= 1;
        }
        lnode.next = rnode.next;
        rnode.next = prev;
        prevLeft.next = rnode;
        if (lnode == head)
            return rnode;
        return head;
    }
}