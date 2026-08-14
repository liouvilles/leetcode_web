class Solution {
public:
    bool isValid(string s) {
        size_t previous;
        do {
            previous = s.size();
            eraseAll(s, "()"); eraseAll(s, "[]"); eraseAll(s, "{}");
        } while (s.size() != previous);
        return s.empty();
    }

private:
    void eraseAll(string& s, const string& pair) {
        size_t pos;
        while ((pos = s.find(pair)) != string::npos) s.erase(pos, 2);
    }
};
