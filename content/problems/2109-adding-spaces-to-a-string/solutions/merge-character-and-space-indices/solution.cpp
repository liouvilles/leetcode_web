class Solution {
    public: string addSpaces(string s,vector<int>& spaces){
        string answer;
        int next=0;
        for(int i=0;i<(int)s.size();++i){
            if(next<(int)spaces.size()&&spaces[next]==i){
                answer+=' ';
                ++next;
            }
            answer+=s[i];
        }
        return answer;
    }
};
