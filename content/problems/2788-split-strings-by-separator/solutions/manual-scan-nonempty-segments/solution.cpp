class Solution {
    public:vector<string> splitWordsBySeparator(vector<string>& words,char separator){
        vector<string> answer;
        for(string& word:words){
            int start=0;
            for(int end=0;end<=(int)word.size();++end)if(end==(int)word.size()||word[end]==separator){
                if(end>start)answer.push_back(word.substr(start,end-start));
                start=end+1;
            }
        }
        return answer;
    }
};
