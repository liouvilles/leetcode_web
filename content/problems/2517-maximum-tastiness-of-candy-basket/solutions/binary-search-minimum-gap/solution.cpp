class Solution {
    bool possible(vector<int>& price,int k,int distance){
        int count=1,last=price[0];
        for(int value:price)if(value-last>=distance){
            ++count;
            last=value;
            if(count>=k)return true;
        }
        return count>=k;
    }
    public:int maximumTastiness(vector<int>& price,int k){
        sort(price.begin(),price.end());
        int left=0,right=(price.back()-price.front())/(k-1);
        while(left<right){
            int middle=(left+right+1)/2;
            if(possible(price,k,middle))left=middle;
            else right=middle-1;
        }
        return left;
    }
};
