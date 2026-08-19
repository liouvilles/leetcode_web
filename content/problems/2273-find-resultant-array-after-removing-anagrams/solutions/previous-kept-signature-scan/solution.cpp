class Solution {
    public:vector<string> removeAnagrams(vector<string>& words){
        vector<string> answer;
        string previous;
        for(string& word:words){
            string current=word;
            sort(current.begin(),current.end());
            if(current!=previous){
                answer.push_back(word);
                previous=current;
            }
        }
        return answer;
    }
};
