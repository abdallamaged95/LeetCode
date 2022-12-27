class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> mine(nums);
        sort(mine.begin() ,mine.end());
        int head=0 ,tail=mine.size()-1;
        vector<int> ans;
        while(head < tail){
            if (mine[head] + mine[tail] > target)
                tail--;
            else if (mine[head] + mine[tail] < target)
                head++;
            else if (mine[head] + mine[tail] == target){
                cout << mine[head] << ' ' << mine[tail] << '\n';
                break;
            }
        }

        for (int i = 0 ; i < nums.size() ;i++){
            if (nums[i] == mine[head]){
                ans.push_back(i);
                continue;
            }
            else if (nums[i] == mine[tail]){
                ans.push_back(i);
                continue;
            }
        }
        return ans;
    }
};