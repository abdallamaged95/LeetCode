class Solution {
public:
    bool canJump(vector<int>& nums) {
        // bool* visited = new bool[nums.size()]{false};
        reverse(nums.begin(), nums.end());
        return solve(nums);
    }

    bool solve(vector<int>& nums) {
        int lastPos = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] >= (i - lastPos)) {
                lastPos = i;
            }
            if (lastPos == nums.size() - 1) {
                return true;
            }
        }
        return false;
    }
};