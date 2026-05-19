/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int stepsA = 1, stepsB = 1;
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA.next != null || nodeB.next != null) {
            if (nodeA == nodeB && stepsA == stepsB)
                return nodeA;
            if (nodeA.next != null) {
                nodeA = nodeA.next;
                stepsA += 1;
            }
            if (nodeB.next != null) {
                nodeB = nodeB.next;
                stepsB += 1;
            }
        }
        if (nodeA != nodeB)
            return null;
        nodeA = headA;
        nodeB = headB;
        while (stepsB > stepsA) {
            nodeB = nodeB.next;
            stepsB -= 1;
        }
        while (stepsA > stepsB) {
            nodeA = nodeA.next;
            stepsA -= 1;
        }
        while (nodeA != null && nodeB != null && nodeA != nodeB) {
            nodeB = nodeB.next;
            nodeA = nodeA.next;
        }
        if (nodeA == null || nodeB == null)
            return null;
        return nodeB;
    }
}