class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        auto product = selfProduct(nums);
        vector<int> result;
        for (int i = 0; i < nums.size(); i++)
        {
            if (product.second)
            {
                if (nums[i] != 0)
                    result.push_back(0);
                else if (nums[i] == 0)
                {
                    if (product.second > 1)
                        result.push_back(0);
                    else if (product.second == 1)
                        result.push_back(product.first);
                }
            }
            else
                result.push_back(product.first / nums[i]);   
        }
        return result;
    }
    pair<int ,int> selfProduct(vector<int> nums)
    {
        int res = 1;
        int zeros = 0;
        for (int i : nums)
        {
            if (i != 0)
                res *= i;
            if (i == 0)
                zeros++;
        }
        if (zeros == nums.size())
            res = 0;
        return make_pair(res, zeros);
    }
};