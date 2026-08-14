class Solution {
    public int[] plusOne(int[] digits) {
        for (int index = digits.length - 1; index >= 0; index--) { if (digits[index] < 9) { digits[index]++; return digits; } digits[index] = 0; }
        int[] answer = new int[digits.length + 1]; answer[0] = 1; return answer;
    }
}
