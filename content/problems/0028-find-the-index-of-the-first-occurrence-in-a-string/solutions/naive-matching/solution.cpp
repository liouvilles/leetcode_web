class Solution {
public:
    int strStr(string haystack, string needle) {
        for (int start = 0; start + (int)needle.size() <= (int)haystack.size(); ++start) {
            int index = 0;
            while (index < (int)needle.size() && haystack[start + index] == needle[index]) ++index;
            if (index == (int)needle.size()) return start;
        }
        return -1;
    }
};
