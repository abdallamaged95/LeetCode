/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int goodNodes(TreeNode* root) {
        return solve(root);
    }
    
    int solve(TreeNode* node ,int val = INT_MIN)
    {
        if (node == nullptr)
            return 0;
        return solve(node->left ,max(val ,node->val))
            + solve(node->right ,max(val ,node->val)) + (int)(node->val >= val);
    }
};