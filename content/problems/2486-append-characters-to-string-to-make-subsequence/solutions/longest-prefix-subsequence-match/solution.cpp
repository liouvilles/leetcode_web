class Solution { public:int appendCharacters(string s,string t){int matched=0;for(char character:s)if(matched<(int)t.size()&&character==t[matched])++matched;return t.size()-matched;} };
