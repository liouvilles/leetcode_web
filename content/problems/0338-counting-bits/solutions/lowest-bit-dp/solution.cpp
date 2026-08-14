class Solution {
public:
    vector<int> countBits(int n) { vector<int> bits(n + 1); for (int value = 1; value <= n; ++value) bits[value] = bits[value >> 1] + (value & 1); return bits; }
};
