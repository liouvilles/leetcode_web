class Solution {
public:
    bool isAnagram(string first, string second) {
        if (first.size() != second.size()) return false;
        array<int, 26> counts{};
        for (int index = 0; index < (int)first.size(); ++index) { ++counts[first[index] - 'a']; --counts[second[index] - 'a']; }
        return all_of(counts.begin(), counts.end(), [](int count) { return count == 0; });
    }
};
