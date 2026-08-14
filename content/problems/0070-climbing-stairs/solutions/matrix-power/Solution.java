class Solution {
    public int climbStairs(int n) {
        long[][] result = {{1, 0}, {0, 1}};
        long[][] base = {{1, 1}, {1, 0}};
        int power = n;
        while (power > 0) {
            if ((power & 1) == 1) result = multiply(result, base);
            base = multiply(base, base);
            power >>= 1;
        }
        return (int) result[0][0];
    }

    private long[][] multiply(long[][] a, long[][] b) {
        return new long[][] {
            {a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1]},
            {a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1]}
        };
    }
}
