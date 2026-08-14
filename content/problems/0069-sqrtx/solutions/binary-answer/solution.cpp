class Solution {
public:
    int mySqrt(int x) {
        int left = 0, right = x, answer = 0;
        while (left <= right) { int middle = left + (right - left) / 2; if ((long long)middle * middle <= x) { answer = middle; left = middle + 1; } else right = middle - 1; }
        return answer;
    }
};
