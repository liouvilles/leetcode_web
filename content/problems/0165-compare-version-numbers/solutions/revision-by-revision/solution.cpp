class Solution {
    vector<long long> parse(const string& version) { vector<long long> values; string part; stringstream stream(version); while (getline(stream, part, '.')) values.push_back(stoll(part)); return values; }
public:
    int compareVersion(string version1, string version2) { vector<long long> first = parse(version1), second = parse(version2); for (int index = 0; index < (int)max(first.size(), second.size()); ++index) { long long left = index < (int)first.size() ? first[index] : 0, right = index < (int)second.size() ? second[index] : 0; if (left < right) return -1; if (left > right) return 1; } return 0; }
};
