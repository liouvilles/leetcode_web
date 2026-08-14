class Solution {
    using Matrix = array<long long, 4>;

public:
    int climbStairs(int n) {
        Matrix result{1, 0, 0, 1};
        Matrix base{1, 1, 1, 0};
        while (n > 0) {
            if (n & 1) result = multiply(result, base);
            base = multiply(base, base);
            n >>= 1;
        }
        return result[0];
    }

private:
    Matrix multiply(const Matrix& a, const Matrix& b) {
        return {a[0] * b[0] + a[1] * b[2], a[0] * b[1] + a[1] * b[3],
                a[2] * b[0] + a[3] * b[2], a[2] * b[1] + a[3] * b[3]};
    }
};
