class Solution {
    public: string longestNiceSubstring(string text){
        if(text.size()<2)return "";
        unordered_set<char> set(text.begin(),text.end());
        for(int i=0;i<(int)text.size();++i){
            char lower=tolower(text[i]),upper=toupper(text[i]);
            if(!set.count(lower)||!set.count(upper)){
                string left=longestNiceSubstring(text.substr(0,i)),right=longestNiceSubstring(text.substr(i+1));
                return left.size()>=right.size()?left:right;
            }
        }
        return text;
    }
};
