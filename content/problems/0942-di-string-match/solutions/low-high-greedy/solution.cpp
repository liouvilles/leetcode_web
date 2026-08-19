class Solution {
    public: vector<int> diStringMatch(string s){
        vector<int> answer(s.size()+1);
        int low=0,high=s.size();
        for(int i=0;i<(int)s.size();++i)answer[i]=s[i]=='I'?low++:high--;
        answer[s.size()]=low;
        return answer;
    }
};
