class Solution {
    int value(char symbol) {
        if (symbol == 'I') return 1;
        if (symbol == 'V') return 5;
        if (symbol == 'X') return 10;
        if (symbol == 'L') return 50;
        if (symbol == 'C') return 100;
        if (symbol == 'D') return 500;
        return 1000;
    }
public:
    int romanToInt(string s) {
        int total = 0;
        for (int index = 0; index < (int)s.size(); ++index) {
            int current = value(s[index]);
            int next = index + 1 < (int)s.size() ? value(s[index + 1]) : 0;
            total += current < next ? -current : current;
        }
        return total;
    }
};
