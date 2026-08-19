class Solution {
    int frequency(const string& text){
        char minimum='z';
        int count=0;
        for(char ch:text)if(ch<minimum){
            minimum=ch;
            count=1;
        }else if(ch==minimum)++count;
        return count;
    }
    public:vector<int> numSmallerByFrequency(vector<string>& queries,vector<string>& words){
        vector<int> frequencies;
        for(string& word:words)frequencies.push_back(frequency(word));
        sort(frequencies.begin(),frequencies.end());
        vector<int> answer;
        for(string& query:queries)answer.push_back(frequencies.end()-upper_bound(frequencies.begin(),frequencies.end(),frequency(query)));
        return answer;
    }
};
