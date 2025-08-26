#define st                  first
#define nd                  second
class Solution {
public:
    void pair_new_min_value(pair<pair<int, int>, pair<int, int>>& p, pair<int, int> x) {
        if (x.st < p.nd.st && x.st >= p.st.st) {
            p.nd = x;
        }
        else if (x.st < p.st.st) {
            p.nd = p.st;
            p.st = x;
        }
    }

    void pair_new_max_value(pair<pair<int, int>, pair<int, int>>& p, pair<int, int> x) {
        if (x.st > p.nd.st && x.st <= p.st.st) {
            p.nd = x;
        }
        else if (x.st > p.st.st) {
            p.nd = p.st;
            p.st = x;
        }
    }
    int maxDistance(vector<vector<int>>& arrays) {
        pair<pair<int, int>, pair<int, int>> max_pair = {{INT_MIN, -1}, {INT_MIN, -1}}, min_pair = {{INT_MAX, -1}, {INT_MAX, -1}};
        for (int i = 0; i < arrays.size(); i++) {
            if (arrays[i][0] < min_pair.st.st || arrays[i][0] < min_pair.nd.st) {
                pair_new_min_value(min_pair, {arrays[i][0], i});
            }
            if (arrays[i][arrays[i].size() - 1] > max_pair.st.st || arrays[i][arrays[i].size() - 1] > max_pair.nd.st) {
                pair_new_max_value(max_pair, {arrays[i][arrays[i].size() - 1], i});
            }
        }
        if (max_pair.st.nd != min_pair.st.nd) {
            return max_pair.st.st - min_pair.st.st;
        }
        return max(max_pair.st.st - min_pair.nd.st, max_pair.nd.st - min_pair.st.st);
    }
};