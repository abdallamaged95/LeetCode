class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if (nums.size() == 1)
            return nums[0];
        int sum = nums[0], tmp = nums[0];
        for (int i = 1; i < nums.size(); i++)
        {
            tmp = max(tmp+nums[i], nums[i]);
            sum = max(sum ,tmp);
        }
        return sum;
    }
};