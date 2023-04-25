class Solution {
public:
    vector<vector<int>> perms;
    vector<int> n;
    vector<bool> visit;
    void solve(vector<int> perm = {})
    {
        if (perm.size() == n.size())
            perms.push_back(perm);

        for (int i = 0 ; i < n.size() ; i++){
            if (!visit[i]){
                perm.push_back(n[i]);
                visit[i] = true;
                solve(perm);
                perm.pop_back();
                visit[i] = false;
            }
        }
    }
    vector<vector<int>> permute(vector<int>& nums)
    {
        vector<bool> tmp(nums.size());
        visit = tmp;
        n = nums;
        solve();
        return perms;
    }
};