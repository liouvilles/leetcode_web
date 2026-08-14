class Solution {
public:
    int hammingWeight(int n) {
        unsigned int value = n; int answer = 0;
        while (value) { value &= value - 1; ++answer; }
        return answer;
    }
};
