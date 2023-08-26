class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if (nums.size() < 2)
            return nums.size();
        sort(nums.begin(), nums.end());
        int longest = 0;
        int length = 1;
        for (int i = 1; i < nums.size(); i++)
        {
            if (nums[i] - nums[i-1] == 1)
                length++;
            else if (nums[i] != nums[i-1])
            {
                longest = max(longest, length);
                length = 1;
            }
        }
        longest = max(longest, length);
        return longest;
    }
};