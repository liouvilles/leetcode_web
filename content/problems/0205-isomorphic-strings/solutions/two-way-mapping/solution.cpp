class Solution {
public:
    bool isIsomorphic(string s, string t) {
        array<int, 256> forward, backward; forward.fill(-1); backward.fill(-1);
        for (int index = 0; index < (int)s.size(); ++index) { unsigned char first = s[index], second = t[index]; if (forward[first] == -1 && backward[second] == -1) { forward[first] = second; backward[second] = first; } else if (forward[first] != second || backward[second] != first) return false; }
        return true;
    }
};
