class Solution {
    public:vector<int> executeInstructions(int n,vector<int>& startPos,string s){
        vector<int> answer(s.size());
        for(int begin=0;begin<(int)s.size();++begin){
            int row=startPos[0],column=startPos[1];
            for(int i=begin;i<(int)s.size();++i){
                int nextRow=row,nextColumn=column;
                if(s[i]=='L')--nextColumn;
                else if(s[i]=='R')++nextColumn;
                else if(s[i]=='U')--nextRow;
                else ++nextRow;
                if(nextRow<0||nextRow>=n||nextColumn<0||nextColumn>=n)break;
                row=nextRow;
                column=nextColumn;
                ++answer[begin];
            }
        }
        return answer;
    }
};
