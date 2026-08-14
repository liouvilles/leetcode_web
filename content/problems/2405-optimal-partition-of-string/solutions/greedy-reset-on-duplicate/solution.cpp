class Solution { public:int partitionString(string s){int groups=1,mask=0;for(char ch:s){int bit=1<<(ch-'a');if(mask&bit){++groups;mask=0;}mask|=bit;}return groups;} };
