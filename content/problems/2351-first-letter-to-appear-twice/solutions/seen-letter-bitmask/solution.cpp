class Solution { public:char repeatedCharacter(string s){int mask=0;for(char ch:s){int bit=1<<(ch-'a');if(mask&bit)return ch;mask|=bit;}return 0;} };
