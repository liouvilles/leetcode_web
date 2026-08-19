class Solution {
    long long gcdValue(long long first,long long second){
        while(second){
            long long value=first%second;
            first=second;
            second=value;
        }
        return first;
    }
    long long countAmounts(vector<int>& coins,long long limit){
        long long total=0;
        for(int mask=1;mask<(1<<(int)coins.size());++mask){
            long long lcm=1;
            int bits=0;
            bool tooLarge=false;
            for(int index=0;index<(int)coins.size();++index)if(mask>>index&1){
                ++bits;
                long long divisor=gcdValue(lcm,coins[index]);
                if(lcm/divisor>limit/coins[index]){
                    tooLarge=true;
                    break;
                }
                lcm=lcm/divisor*coins[index];
            }
            if(!tooLarge){
                long long occurrences=limit/lcm;
                total+=bits&1?occurrences:-occurrences;
            }
        }
        return total;
    }
    public:long long findKthSmallest(vector<int>& coins,int k){
        long long low=1,high=1LL*(*min_element(coins.begin(),coins.end()))*k;
        while(low<high){
            long long middle=low+(high-low)/2;
            if(countAmounts(coins,middle)>=k)high=middle;
            else low=middle+1;
        }
        return low;
    }
};
