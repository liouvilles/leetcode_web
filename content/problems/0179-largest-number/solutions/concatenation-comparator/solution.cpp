class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<string> values; for (int value : nums) values.push_back(to_string(value));
        sort(values.begin(), values.end(), [](const string& first, const string& second) { return first + second > second + first; });
        if (values[0] == "0") return "0";
        return accumulate(values.begin(), values.end(), string());
    }
};
