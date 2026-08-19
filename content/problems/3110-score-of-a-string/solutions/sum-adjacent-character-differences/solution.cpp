class Solution { public:int scoreOfString(string s){int answer=0;for(int index=1;index<(int)s.size();++index)answer+=abs(s[index]-s[index-1]);return answer;} };
