class Solution {
    public: bool isPrefixString(string s,vector<string>& words){
        string value;
        for(string& word:words){
            value+=word;
            if(value.size()>=s.size())return value==s;
        }
        return false;
    }
};
