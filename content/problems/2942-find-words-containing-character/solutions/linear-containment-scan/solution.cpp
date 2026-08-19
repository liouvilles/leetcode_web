class Solution {
    public:vector<int> findWordsContaining(vector<string>& words,char x){
        vector<int> answer;
        for(int index=0;index<(int)words.size();++index)if(words[index].find(x)!=string::npos)answer.push_back(index);
        return answer;
    }
};
