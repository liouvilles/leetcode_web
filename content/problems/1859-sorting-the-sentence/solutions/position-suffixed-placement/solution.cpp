class Solution {
    public: string sortSentence(string sentence){
        stringstream stream(sentence);
        vector<string> result(9);
        string word;
        int count=0;
        while(stream>>word){
            result[word.back()-'1']=word.substr(0,word.size()-1);
            ++count;
        }
        string answer;
        for(int i=0;i<count;++i){
            if(i)answer+=' ';
            answer+=result[i];
        }
        return answer;
    }
};
