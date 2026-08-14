class Solution {
public:
    vector<int> grayCode(int n) { vector<int> answer; for (int value = 0; value < (1 << n); ++value) answer.push_back(value ^ (value >> 1)); return answer; }
};
