class Solution { public:int removeAlmostEqualCharacters(string word){int operations=0;for(int i=1;i<(int)word.size();++i)if(abs(word[i]-word[i-1])<=1){++operations;++i;}return operations;} };
