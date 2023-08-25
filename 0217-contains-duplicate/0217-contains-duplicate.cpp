class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        map<int, bool> distinct;
        for (int i : nums)
        {
            if (distinct.find(i) != distinct.end())
                return true;
            else
                distinct.insert(make_pair(i, true));
        }
        return false;
    }
};