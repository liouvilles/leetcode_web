class Solution { public:int minimumPushes(string word){int full=word.size()/8,remaining=word.size()%8;return 8*full*(full+1)/2+(full+1)*remaining;} };
