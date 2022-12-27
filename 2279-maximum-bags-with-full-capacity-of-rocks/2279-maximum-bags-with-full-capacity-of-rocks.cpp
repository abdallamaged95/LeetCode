class Solution {
public:
    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
                vector<int> remaining;
        for (int i = 0 ; i < capacity.size() ; i++){
            int x = capacity[i] - rocks[i];
            remaining.push_back(x);
        }
        sort(remaining.begin() ,remaining.end());
        int filled = 0;
        for (int i = 0 ; i < remaining.size() ;i++){
            if (additionalRocks >= remaining[i]){
                additionalRocks -= remaining[i];
                filled ++;
            }
        }
        return filled;
    }
};