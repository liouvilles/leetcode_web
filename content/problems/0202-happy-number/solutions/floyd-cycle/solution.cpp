class Solution {
    int next(int value) { int sum = 0; while (value > 0) { int digit = value % 10; sum += digit * digit; value /= 10; } return sum; }
public:
    bool isHappy(int n) {
        int slow = n, fast = next(n);
        while (fast != 1 && slow != fast) { slow = next(slow); fast = next(next(fast)); }
        return fast == 1;
    }
};
