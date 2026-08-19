class Solution {
    public: bool isTransformable(string s,string t){
        array<queue<int>,10> positions;
        for(int i=0;i<(int)s.size();++i)positions[s[i]-'0'].push(i);
        for(char value:t){
            int digit=value-'0';
            if(positions[digit].empty())return false;
            int position=positions[digit].front();
            for(int smaller=0;smaller<digit;++smaller)if(!positions[smaller].empty()&&positions[smaller].front()<position)return false;
            positions[digit].pop();
        }
        return true;
    }
};
