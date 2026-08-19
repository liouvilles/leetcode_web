class Solution {
    public:int mostWordsFound(vector<string>& sentences){
        int answer=0;
        for(string& sentence:sentences)answer=max(answer,1+(int)count(sentence.begin(),sentence.end(),' '));
        return answer;
    }
};
