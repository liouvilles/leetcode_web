class Solution {
    bool border(const string& prefix,const string& word){
        if(prefix.size()>word.size())return false;
        return word.compare(0,prefix.size(),prefix)==0&&word.compare(word.size()-prefix.size(),prefix.size(),prefix)==0;
    }
    public:int countPrefixSuffixPairs(vector<string>& words){
        int answer=0;
        for(int i=0;i<(int)words.size();++i)for(int j=i+1;j<(int)words.size();++j)if(border(words[i],words[j]))++answer;
        return answer;
    }
};
