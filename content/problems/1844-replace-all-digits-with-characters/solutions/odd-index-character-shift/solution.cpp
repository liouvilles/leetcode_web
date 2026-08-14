class Solution { public: string replaceDigits(string text){for(int i=1;i<(int)text.size();i+=2)text[i]=text[i-1]+text[i]-'0';return text;} };
