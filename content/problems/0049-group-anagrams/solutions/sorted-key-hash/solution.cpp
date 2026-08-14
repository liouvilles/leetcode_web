class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, int> indexByKey;
        vector<vector<string>> groups;
        for (const string& value : strs) {
            string key = value;
            sort(key.begin(), key.end());
            auto [it, inserted] = indexByKey.emplace(key, groups.size());
            if (inserted) groups.push_back({});
            groups[it->second].push_back(value);
        }
        return groups;
    }
};
