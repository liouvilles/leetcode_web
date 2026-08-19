class Solution {
    public: vector<int> maxDepthAfterSplit(string seq){
        vector<int> answer(seq.size());
        int depth=0;
        for(int i=0;i<(int)seq.size();++i)if(seq[i]=='(')answer[i]=depth++%2;
        else answer[i]=--depth%2;
        return answer;
    }
};
