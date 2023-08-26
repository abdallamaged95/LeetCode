class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> sol(n+1);
        for (int i = 0; i < sol.size(); i++)
            sol[i] = hammingWeight(i);
        return sol;
    }
    int hammingWeight(int n) {
        int res = 0;
        while (n != 0)
        {
            if (n & 1)
                res++;
            n = n >> 1;
        }
        return res;
    }
};