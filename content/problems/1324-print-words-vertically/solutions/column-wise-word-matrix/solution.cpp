class Solution {
    public: vector<string> printVertically(string s){
        stringstream stream(s);
        vector<string> words;
        string word;
        int maximum=0;
        while(stream>>word){
            maximum=max(maximum,(int)word.size());
            words.push_back(word);
        }
        vector<string> answer;
        for(int column=0;column<maximum;++column){
            string line;
            for(string& value:words)line+=column<(int)value.size()?value[column]:' ';
            while(!line.empty()&&line.back()==' ')line.pop_back();
            answer.push_back(line);
        }
        return answer;
    }
};
