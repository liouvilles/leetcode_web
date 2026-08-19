class Solution {
    public: int minimumMoves(string s){
        int answer=0;
        for(int index=0;index<(int)s.size();)if(s[index]=='X'){
            ++answer;
            index+=3;
        }else ++index;
        return answer;
    }
};
