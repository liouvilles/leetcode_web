class Solution { public: bool isSubsequence(string s,string t){int matched=0;for(char c:t)if(matched<(int)s.size()&&c==s[matched])++matched;return matched==(int)s.size();} };
