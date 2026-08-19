class Solution {
    public: int numOfStrings(vector<string>& patterns,string word){
        int answer=0;
        for(string& pattern:patterns)answer+=word.find(pattern)!=string::npos;
        return answer;
    }
};
