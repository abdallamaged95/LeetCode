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
    void rotate(vector<int>& nums, int k) {
        if (nums.size() == 1 || k == 0 || k % nums.size() == 0)
            return;
        k %= nums.size();
        swapRange(nums, 0, nums.size() - 1);
        swapRange(nums, 0, k - 1);
        swapRange(nums, k, nums.size() - 1);
        
    }

    void solve(V<int>& nums, int k) {
        int idx = 0;
        int dest = (idx + k) % nums.size();
        for (int i = 0; i < nums.size(); i++) {
            swap(nums, 0, dest);
            idx = dest;
            dest = (idx + k) % nums.size();
        }
    }

    void swap(V<int>& nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    void swapRange(V<int>& nums, int l, int r) {
        int n = (r - l) / 2;
        for (int i = 0; i <= n; i++) {
            swap(nums, l + i, r - i);
        }
    }
};