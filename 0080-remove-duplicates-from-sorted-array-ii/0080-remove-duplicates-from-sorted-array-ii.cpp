#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <map>
#include <math.h>
using namespace std;
typedef long long           ll;
typedef unsigned long long  ull;
typedef long double         ld;
#define V                   vector
#define st                  first
#define nd                  second
#define IamVengeance        ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
#define v_print(v)          for(auto it : v) { cout << it << ' '; } cout << '\n'
#define m_print(m)          for(auto it : m) { cout << it.st << " : " << it.nd << '\n'; } cout << '\n'
#define p_add(x ,y)         make_pair(x.st + y.st ,x.nd + y.nd)
#define p_mult(x ,y)        make_pair(x.st * y.st ,x.nd * y.nd)
#define precision(n,m)      fixed << setprecision(m) << n
#define PI                  3.14159265358979323846
//#include "Functions.h"

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() < 3)
            return nums.size();
        else if (nums.size() == 3)
        {
            if (nums[2] == nums[1] && nums[2] == nums[0])
                return 2;
        }

        int k = nums.size();
        for (int i = nums.size()-2; i >= 2; i--) {
            if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2])
            {
                k--;
                solve(nums, i, k);
            }
        }
        for (int i = 2; i < nums.size(); i++)
            if (nums[i] < nums[i - 1] || (nums[i] == nums[i - 1] && nums[i] == nums[i - 2]))
                return i;
        return k;
    }

    void solve(V<int>& nums, int l, int r) {
        swap(nums, l, r);
        if ((l + 1) == r)
            return;
        // base case
        int swapWith = -1;
        for (int j = nums[l] - 1; j >= nums[l - 1]; j--)
        {
            swapWith = myBinarySearch(nums, j, l+1, r-1);
            if (swapWith != -1)
                break;
        }
        if (swapWith == -1)
            return;
        solve(nums, l, swapWith);
    }

    int myBinarySearch(V<int>& nums, int n, int l, int r) {
        int mid = (l + r) / 2;
        int maxIdx = -1;
        while (r - l > 1)
        {
            mid = (l + r) / 2;
            if (nums[mid] == n)
            {
                maxIdx = max(maxIdx, mid);
                l = mid;
            }
            else if (nums[mid] > n)
                r = mid;
            else if (nums[mid] < n)
                l = mid;
        }
        if (nums[l] == n)
            maxIdx = max(maxIdx, l);
        if (nums[r] == n)
            maxIdx = max(maxIdx, r);
        return maxIdx;
    }

    void swap(V<int>& nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
};