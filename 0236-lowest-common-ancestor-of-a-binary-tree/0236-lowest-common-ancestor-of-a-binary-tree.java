/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private class Pair {
        public Pair(Boolean st, Boolean nd) {
            b1 = st;
            b2 = nd;
        }
        public Boolean b1;
        public Boolean b2;
        public Pair or(Pair p1, Pair p2) {
            return new Pair((p1.b1 || p2.b1), (p1.b2 || p2.b2));
        }
    }
    public TreeNode ansNode, n1, n2;
    public Boolean f1, f2;
    // public int found = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        n1 = p;
        n2 = q;
        f1 = f2 = false;
        ansNode = null;
        solve(root);
        System.out.println(ansNode.val);
        return ansNode;
    }
    public Pair solve(TreeNode node) {
        if (node == null)
            return new Pair(false, false);

        Pair ans = new Pair((node == n1), (node == n2));

        Pair ansL = solve(node.left);
        ans = ans.or(ans, ansL);
        if (ans.b1 && ans.b2) {
            if (ansNode == null)
                ansNode = node;
            return ans;
        }

        Pair ansR = solve(node.right);
        ans = ans.or(ans, ansR);

        if (ans.b1 && ans.b2 && ansNode == null)
            ansNode = node;
        return ans;
    }
}