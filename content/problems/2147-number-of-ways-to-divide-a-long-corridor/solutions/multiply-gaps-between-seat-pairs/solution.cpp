class Solution {
    public:int numberOfWays(string corridor){
        long long ways=1;
        int seats=0,previousSecond=-1;
        for(int i=0;i<(int)corridor.size();++i)if(corridor[i]=='S'){
            ++seats;
            if(seats>2&&seats%2)ways=ways*(i-previousSecond)%1000000007;
            if(seats%2==0)previousSecond=i;
        }
        return seats>0&&seats%2==0?ways:0;
    }
};
