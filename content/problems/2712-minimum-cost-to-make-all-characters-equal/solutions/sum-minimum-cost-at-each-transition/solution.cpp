class Solution { public:long long minimumCost(string s){long long answer=0;for(int i=1;i<(int)s.size();++i)if(s[i]!=s[i-1])answer+=min(i,(int)s.size()-i);return answer;} };
