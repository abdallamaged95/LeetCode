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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        ListNode n1 = list1, n2 = list2;
        while (n1 != null && n2 != null) {
            if (n2.val <= n1.val) {
                while (n2.next != null && n2.next.val <= n1.val)
                    n2 = n2.next;
                ListNode tmp = n2;
                n2 = n2.next;
                tmp.next = n1;
            }
            else {
                while (n1.next != null && n1.next.val <= n2.val)
                    n1 = n1.next;
                ListNode tmp = n1;
                n1 = n1.next;
                tmp.next = n2;
            }
        }
        if (list1.val < list2.val) {
            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        return list2;
    }
}