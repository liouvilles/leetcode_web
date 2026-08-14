class Solution {
    public int romanToInt(String s) {
        int total = 0;
        for (int index = 0; index < s.length(); index++) {
            int current = value(s.charAt(index));
            int next = index + 1 < s.length() ? value(s.charAt(index + 1)) : 0;
            total += current < next ? -current : current;
        }
        return total;
    }

    private int value(char symbol) {
        if (symbol == 'I') return 1;
        if (symbol == 'V') return 5;
        if (symbol == 'X') return 10;
        if (symbol == 'L') return 50;
        if (symbol == 'C') return 100;
        if (symbol == 'D') return 500;
        return 1000;
    }
}
