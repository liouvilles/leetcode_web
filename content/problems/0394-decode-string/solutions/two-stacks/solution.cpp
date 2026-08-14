class Solution {
public:
    string decodeString(string s) {
        vector<int> counts; vector<string> prefixes; string current; int repeat = 0;
        for (char symbol : s) { if (isdigit(symbol)) repeat = repeat * 10 + symbol - '0'; else if (symbol == '[') { counts.push_back(repeat); prefixes.push_back(current); current.clear(); repeat = 0; } else if (symbol == ']') { int times = counts.back(); counts.pop_back(); string expanded = prefixes.back(); prefixes.pop_back(); while (times-- > 0) expanded += current; current = move(expanded); } else current.push_back(symbol); }
        return current;
    }
};
