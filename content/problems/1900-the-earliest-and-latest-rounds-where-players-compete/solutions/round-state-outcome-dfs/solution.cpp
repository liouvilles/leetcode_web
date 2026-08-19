class Solution {
    map<tuple<int,int,int>,array<int,2>> memo;
    void enumerate(int n,int first,int second,int pair,int beforeFirst,int beforeSecond,set<int>& states){
        if(pair>n/2){
            if(n%2){
                int middle=(n+1)/2;
                beforeFirst+=middle<first;
                beforeSecond+=middle<second;
            }
            states.insert(beforeFirst*32+beforeSecond);
            return;
        }
        int a=pair,b=n+1-pair;
        auto advance=[&](int winner){
            enumerate(n,first,second,pair+1,beforeFirst+(winner<first),beforeSecond+(winner<second),states);
        };
        if(a==first||b==first)advance(first);
        else if(a==second||b==second)advance(second);
        else{
            advance(a);
            advance(b);
        }
    }
    array<int,2> solve(int n,int first,int second){
        if(first+second==n+1)return {
            1,1
        };
        if(first+second>n+1){
            int old=first;
            first=n+1-second;
            second=n+1-old;
        }
        auto key=make_tuple(n,first,second);
        if(memo.count(key))return memo[key];
        set<int> states;
        enumerate(n,first,second,1,0,0,states);
        int earliest=100,latest=0,nextN=(n+1)/2;
        for(int state:states){
            auto result=solve(nextN,state/32+1,state%32+1);
            earliest=min(earliest,result[0]+1);
            latest=max(latest,result[1]+1);
        }
        return memo[key]={
            earliest,latest
        };
    }
    public: vector<int> earliestAndLatest(int n,int firstPlayer,int secondPlayer){
        auto result=solve(n,firstPlayer,secondPlayer);
        return {
            result[0],result[1]
        };
    }
};
