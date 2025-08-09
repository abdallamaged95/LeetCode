class Solution {
public:
    bool canJump(vector<int>& nums) {
        reverse(nums.begin(), nums.end());
        return solve(nums);
    }
    
    bool solve(vector<int>& nums) {
        queue<int> q;
        q.push(0);
        bool* visited = new bool[nums.size()]{false};
        visited[0] = true;
        while (!q.empty()) {
            int curr = q.front();
            if (curr == nums.size() - 1) {
                return true;
            }
            q.pop();
            for (int i = curr+1; i < nums.size(); i++) {
                if (nums[i] >= (i - curr) && !visited[i]) {
                    visited[i] = true;
                    q.push(i);

                }
            }
        }
        return false;
    }
};