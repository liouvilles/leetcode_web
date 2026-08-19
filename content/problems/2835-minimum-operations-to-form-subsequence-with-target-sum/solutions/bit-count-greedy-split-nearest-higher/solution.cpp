class Solution {
    public:int minOperations(vector<int>& nums,int target){
        long long total=0,count[32]={
        };
        for(int value:nums){
            total+=value;
            ++count[__builtin_ctz(value)];
        }
        if(total<target)return -1;
        int operations=0;
        for(int bit=0;bit<=30;++bit){
            if(target>>bit&1){
                if(!count[bit]){
                    int higher=bit+1;
                    while(higher<32&&!count[higher])++higher;
                    while(higher>bit){
                        --count[higher];
                        count[higher-1]+=2;
                        --higher;
                        ++operations;
                    }
                }
                --count[bit];
            }
            count[bit+1]+=count[bit]/2;
        }
        return operations;
    }
};
