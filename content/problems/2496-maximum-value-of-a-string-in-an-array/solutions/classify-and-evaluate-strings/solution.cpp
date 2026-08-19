class Solution {
    public:int maximumValue(vector<string>& strs){
        int answer=0;
        for(string& word:strs){
            bool numeric=all_of(word.begin(),word.end(),::isdigit);
            int value=numeric?stoi(word):word.size();
            answer=max(answer,value);
        }
        return answer;
    }
};
