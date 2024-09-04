#include <iostream>
#include <queue>
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
    pair<int, int> dir[4] = { {0,1}, {0,-1}, {1,0}, {-1,0} };
    V<V<bool>> visited;
    int numIslands(vector<vector<char>>& grid) {
        visited.resize(grid.size(), V<bool>(grid[0].size(), false));
        int cnt = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    cnt++;
                    BFS(make_pair(i, j), grid);
                }
            }
        }
        return cnt;
    }

    bool valid(pair<int, int> v, int n, int m) {
        if (v.st < n && v.st >= 0 && v.nd < m && v.nd >= 0)
            return true;
        return false;
    }

    void BFS(pair<int, int> v, V<V<char>>& grid) {
        visited[v.st][v.nd] = true;
        queue<pair<int, int>> q;
        q.push(v);
        while (!q.empty()) {
            auto curr = q.front();
            //visited[curr.st][curr.nd] = true;
            q.pop();
            for (auto d : dir) {
                auto nxt = p_add(curr, d);
                if (valid(nxt, grid.size(), grid[0].size()) && !visited[nxt.st][nxt.nd]
                    && grid[nxt.st][nxt.nd] == '1')
                {
                    visited[nxt.st][nxt.nd] = true;
                    q.push(nxt); 
                }
            }

        }
    }
};