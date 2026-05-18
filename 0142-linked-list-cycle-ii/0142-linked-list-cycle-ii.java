/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode curr = head;
        int idx = 1;
        while (curr != null) {
            if (map.containsKey(curr))
                return curr;
            map.put(curr, idx);
            idx += 1;
            curr = curr.next;
        }
        return null;
    }
}