class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        int max = *max_element(nums.begin(), nums.end());
        int min = *min_element(nums.begin(), nums.end());
        int range = max - min;

        vector<int> arr(range+1);
        for (int i = 0; i < nums.size(); i++) {
            arr[nums[i]-min]++;
        }
        vector<int> ans(nums.size());
        int idx = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr[i]; j++, idx++) {
                ans[idx] = i+min;
            }
        }
        return ans;
    }
};