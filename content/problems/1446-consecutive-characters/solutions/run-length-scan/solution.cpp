class Solution { public: int maxPower(string text){int current=1,answer=1;for(int i=1;i<(int)text.size();++i){current=text[i]==text[i-1]?current+1:1;answer=max(answer,current);}return answer;} };
