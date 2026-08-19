class Solution {
    public: string arrangeWords(string text){
        text[0]=tolower(text[0]);
        stringstream stream(text);
        vector<string> words;
        string word;
        while(stream>>word)words.push_back(word);
        stable_sort(words.begin(),words.end(),[](const string& a,const string& b){
            return a.size()<b.size();
        });
        string answer;
        for(auto& value:words){
            if(!answer.empty())answer+=' ';
            answer+=value;
        }
        answer[0]=toupper(answer[0]);
        return answer;
    }
};
