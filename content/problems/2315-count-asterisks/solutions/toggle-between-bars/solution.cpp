class Solution { public:int countAsterisks(string s){bool inside=false;int answer=0;for(char ch:s)if(ch=='|')inside=!inside;else if(ch=='*'&&!inside)++answer;return answer;} };
