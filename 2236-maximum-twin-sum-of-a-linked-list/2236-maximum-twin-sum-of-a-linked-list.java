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
    public int pairSum(ListNode head) {
        ListNode s = head, f = head.next;
        while(f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode mid = s.next;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (mid != null) {
            stack.push(mid);
            mid = mid.next;
        }
        int sum = 0;
        while(!stack.empty()) {
            sum = Math.max(sum, stack.pop().val + head.val);
            head = head.next;
        }
        return sum;
    }
}