class Solution {
public:
    int rob(vector<int>& nums) {
        int beforePrevious = 0, previous = 0;
        for (int money : nums) {
            int current = max(previous, beforePrevious + money);
            beforePrevious = previous;
            previous = current;
        }
        return previous;
    }
};
