class Solution {
    string key(string& word){
        string value;
        for(int i=1;i<(int)word.size();++i)value+=to_string(word[i]-word[i-1])+",";
        return value;
    }
    public:string oddString(vector<string>& words){
        unordered_map<string,int> frequency;
        for(string& word:words)++frequency[key(word)];
        for(string& word:words)if(frequency[key(word)]==1)return word;
        return "";
    }
};
