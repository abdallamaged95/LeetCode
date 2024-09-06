class Solution {
public:
    int maxProfit(vector<int>& prices) {
        ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
        int sell = 0, profit = 0;
        for (int i = 1; i < prices.size(); i++) {
            profit = max(profit, prices[i] - prices[sell]);
            if (prices[i] < prices[sell])
                sell = i;
        }
        return profit;
    }
};