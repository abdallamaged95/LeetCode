class Solution {
public:
    vector<int> res;
    vector<pair<int ,int>> partialDamage(vector<pair<int, int>> &a, vector<pair<int, int>> &b)
    {
        int i = 0, j = 0;
        vector<pair<int, int>> merged;
        while (i < a.size() && j < b.size())
        {
            if (a[i].first > b[j].first)
            {
                merged.push_back(b[j]);
                j++;
            }
            else if (a[i].first <= b[j].first)
            {
                res[a[i].second] += j;
                merged.push_back(a[i]);
                i++;
            }
        }
        while (i < a.size())
        {
            res[a[i].second] += j;
            merged.push_back(a[i++]);
        }
        while (j < b.size())
            merged.push_back(b[j++]);

        return merged;
    }

    vector<pair<int, int>> MergeSort(vector<pair<int, int>> &arr ,int start ,int end)
    {
        if (end == start+1)
        {
            vector<pair<int, int>> x;
            if (arr[start].first <= arr[end].first)
            {
                x.push_back(arr[start]);
                x.push_back(arr[end]);
            }
            else
            {
                x.push_back(arr[end]);
                x.push_back(arr[start]);
                res[arr[end].second] = 0;
                res[arr[start].second] = 1;
            }
            return x;
        }
        else if (end == start)
            return {arr[end]};

        int mid = (start + end) / 2;
        vector<pair<int, int>> left = MergeSort(arr ,start ,mid);
        vector<pair<int, int>> right = MergeSort(arr ,mid+1 ,end);

        return partialDamage(left, right);
    }
    vector<int> countSmaller(vector<int>& nums) {
        vector<pair<int, int>> arr;
        for (int i = 0; i < nums.size(); i++)
        {
            arr.push_back(make_pair(nums[i], i));
        }
        res.resize(nums.size(), 0);
        MergeSort(arr, 0, arr.size()-1);
        return res;
    }
};