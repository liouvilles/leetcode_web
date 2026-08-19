class Solution {
    public: int longestAwesome(string text){
        int earliest[1<<10];
        fill(begin(earliest),end(earliest),-2);
        earliest[0]=-1;
        int mask=0,answer=0;
        for(int i=0;i<(int)text.size();++i){
            mask^=1<<(text[i]-'0');
            if(earliest[mask]!=-2)answer=max(answer,i-earliest[mask]);
            for(int digit=0;digit<10;++digit){
                int other=mask^(1<<digit);
                if(earliest[other]!=-2)answer=max(answer,i-earliest[other]);
            }
            if(earliest[mask]==-2)earliest[mask]=i;
        }
        return answer;
    }
};
