class Solution { public:int countKeyChanges(string s){int changes=0;for(int i=1;i<(int)s.size();++i)if(tolower((unsigned char)s[i])!=tolower((unsigned char)s[i-1]))++changes;return changes;} };
