class Solution {
    public int reverseBits(int n) {
        int answer = 0;
        for (int bit = 0; bit < 32; bit++) { answer = (answer << 1) | (n & 1); n >>>= 1; }
        return answer;
    }
}
