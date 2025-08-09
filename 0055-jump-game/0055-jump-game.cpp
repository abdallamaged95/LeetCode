class Solution {
public:
    bool canJump(vector<int>& nums) {
        // bool* visited = new bool[nums.size()]{false};
        // reverse(nums.begin(), nums.end());
        return solve(nums);
    }

    bool solve(vector<int>& nums) {
        int lastPos = nums.size() - 1;
        for (int i = nums.size()-1; i >= 0; i--) {
            if (nums[i] >= (lastPos - i)) {
                lastPos = i;
            }
            if (lastPos == 0) {
                return true;
            }
        }
        return false;
    }
};