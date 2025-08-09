class Solution {
public:
    bool canJump(vector<int>& nums) {
        bool* visited = new bool[nums.size()]{false};
        // reverse(nums.begin(), nums.end());
        return solve(nums, visited, nums.size()-1);
    }
    
    bool solve(vector<int>& nums, bool* visited, int idx = 0) {
        if (idx == 0) {
            return true;
        }
        visited[idx] = true;
        for (int i = idx-1; i >= 0; i--) {
            if (nums[i] >= (idx - i) && !visited[i]) {
                if (solve(nums, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }
};