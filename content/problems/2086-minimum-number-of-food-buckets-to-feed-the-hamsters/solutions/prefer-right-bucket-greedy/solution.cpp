class Solution {
    public: int minimumBuckets(string street){
        int answer=0;
        for(int i=0;i<(int)street.size();++i)if(street[i]=='H'){
            if(i&&street[i-1]=='B')continue;
            if(i+1<(int)street.size()&&street[i+1]=='.'){
                street[i+1]='B';
                ++answer;
            }else if(i&&street[i-1]=='.'){
                street[i-1]='B';
                ++answer;
            }else return -1;
        }
        return answer;
    }
};
