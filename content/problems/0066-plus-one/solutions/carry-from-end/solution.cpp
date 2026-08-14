class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int index = digits.size() - 1; index >= 0; --index) { if (digits[index] < 9) { ++digits[index]; return digits; } digits[index] = 0; }
        vector<int> answer(digits.size() + 1); answer[0] = 1; return answer;
    }
};
