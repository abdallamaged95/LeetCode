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
    V<pair<int, int>> region;
    
    void solve(vector<vector<char>>& board) {
        visited.resize(board.size(), V<bool>(board[0].size(), false));
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    bool flag = true;
                    DFS(make_pair(i, j), board, flag);
                    if (flag) {
                        for (auto p : region)
                            board[p.st][p.nd] = 'X';
                    }
                    region.clear();
                }
            }
        }
        
    }

    bool valid(pair<int, int> v, int n, int m) {
        if (v.st < n && v.st >= 0 && v.nd < m && v.nd >= 0)
            return true;
        return false;
    }

    void DFS(pair<int, int> v, V<V<char>>& board, bool& flag) {
        if (valid(v, board.size(), board[0].size()) && (visited[v.st][v.nd] || board[v.st][v.nd] == 'X'))
            return;
        else if (!valid(v, board.size(), board[0].size())) {
            flag = false;
            return;
        }
        if (valid(v, board.size(), board[0].size()))
            visited[v.st][v.nd] = true;
        if (flag)
            region.push_back(v);
        for (auto d : dir) {
            auto nxt = p_add(v, d);
            DFS(nxt, board, flag);
        }
    }
};