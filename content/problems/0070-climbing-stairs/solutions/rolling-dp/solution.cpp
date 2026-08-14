class Solution {
public:
    int climbStairs(int n) {
        int previous = 1, current = 1;
        for (int step = 2; step <= n; ++step) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
};
