class Solution {
    public:int maximumCandies(vector<int>& candies,long long k){
        int left=0,right=*max_element(candies.begin(),candies.end());
        while(left<right){
            int middle=left+(right-left+1)/2;
            long long pieces=0;
            for(int value:candies){
                pieces+=value/middle;
                if(pieces>=k)break;
            }
            if(pieces>=k)left=middle;
            else right=middle-1;
        }
        return left;
    }
};
