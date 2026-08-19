class Solution {
    public:string shiftingLetters(string s,vector<vector<int>>& shifts){
        vector<int> difference(s.size()+1);
        for(auto& shift:shifts){
            int delta=shift[2]?1:-1;
            difference[shift[0]]+=delta;
            difference[shift[1]+1]-=delta;
        }
        int total=0;
        for(int i=0;i<(int)s.size();++i){
            total+=difference[i];
            s[i]='a'+(s[i]-'a'+total%26+26)%26;
        }
        return s;
    }
};
