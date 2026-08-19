class Solution {
    public: int countWords(vector<string>& words1,vector<string>& words2){
        unordered_map<string,int> first,second;
        for(string& word:words1)++first[word];
        for(string& word:words2)++second[word];
        int answer=0;
        for(auto [word,count]:first)answer+=count==1&&second[word]==1;
        return answer;
    }
};
