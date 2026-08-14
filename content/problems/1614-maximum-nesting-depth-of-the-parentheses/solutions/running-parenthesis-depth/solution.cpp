class Solution { public: int maxDepth(string text){int depth=0,answer=0;for(char value:text)if(value=='(')answer=max(answer,++depth);else if(value==')')--depth;return answer;} };
