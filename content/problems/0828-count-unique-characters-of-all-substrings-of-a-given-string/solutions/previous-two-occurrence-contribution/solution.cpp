class Solution {
    public: int uniqueLetterString(string s){
        vector<array<int,2>> positions(26,{
            -1,-1
        });
        int answer=0;
        for(int i=0;i<(int)s.size();++i){
            int c=s[i]-'A';
            answer+=(positions[c][1]-positions[c][0])*(i-positions[c][1]);
            positions[c][0]=positions[c][1];
            positions[c][1]=i;
        }
        for(auto position:positions)answer+=(position[1]-position[0])*(s.size()-position[1]);
        return answer;
    }
};
