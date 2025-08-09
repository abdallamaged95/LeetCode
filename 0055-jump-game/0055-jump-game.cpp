class Solution {
public:
    bool canJump(vector<int>& nums) {
        bool* visited = new bool[nums.size()]{false};
        reverse(nums.begin(), nums.end());
        return solve(nums, visited);
    }
    
    bool solve(vector<int>& nums, bool* visited, int idx = 0) {
        if (idx == nums.size()-1) {
            return true;
        }
        visited[idx] = true;
        for (int i = idx+1; i < nums.size(); i++) {
            if (nums[i] >= (i - idx) && !visited[i]) {
                if (solve(nums, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }
};