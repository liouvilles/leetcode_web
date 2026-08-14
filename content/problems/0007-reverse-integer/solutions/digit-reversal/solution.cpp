class Solution {
public:
    int reverse(int x) {
        long long answer = 0;
        while (x != 0) { answer = answer * 10 + x % 10; x /= 10; }
        return answer < INT_MIN || answer > INT_MAX ? 0 : answer;
    }
};
