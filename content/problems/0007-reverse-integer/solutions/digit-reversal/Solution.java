class Solution {
    public int reverse(int x) {
        long answer = 0;
        while (x != 0) { answer = answer * 10 + x % 10; x /= 10; }
        return answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE ? 0 : (int) answer;
    }
}
