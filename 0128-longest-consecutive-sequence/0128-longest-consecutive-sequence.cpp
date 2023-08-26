class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int length = 0;
        unordered_set<int> seq(nums.begin(), nums.end());
        for (int i : nums)
        {
            if (seq.find(i-1) == seq.end())
            {
                int x = i-1;
                int len = 0;
                while (seq.find(x+1) != seq.end())
                {
                    len++;
                    length = max(length, len);
                    x++;
                }
            }
        }
        return length;
    }
};