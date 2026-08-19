class Solution {
    public: vector<int> powerfulIntegers(int x,int y,int bound){
        set<int> values;
        for(long long a=1;a<=bound;){
            for(long long b=1;b<=bound;){
                if(a+b<=bound)values.insert(a+b);
                if(y==1||b>bound/y)break;
                b*=y;
            }
            if(x==1||a>bound/x)break;
            a*=x;
        }
        return {
            values.begin(),values.end()
        };
    }
};
