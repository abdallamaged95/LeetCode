class Solution {
public:
    bool canJump(vector<int>& nums) {
        reverse(nums.begin(), nums.end());
        return solve(nums);
    }
    
    bool visited[10005] = {false};
    
    bool solve(vector<int>& nums, int idx = 0) {
        if (idx == nums.size()-1) {
            return true;
        }
        visited[idx] = true;
        for (int i = idx+1; i < nums.size(); i++) {
            if (nums[i] >= (i - idx) && !visited[i]) {
                if (solve(nums, i)) {
                    return true;
                }
            }
        }
        return false;
    }
};