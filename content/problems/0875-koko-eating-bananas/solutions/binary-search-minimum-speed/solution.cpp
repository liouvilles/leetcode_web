class Solution {
    public: int minEatingSpeed(vector<int>& piles,int h){
        int low=1,high=*max_element(piles.begin(),piles.end());
        while(low<high){
            int middle=low+(high-low)/2;
            long long hours=0;
            for(int pile:piles)hours+=(pile+middle-1)/middle;
            if(hours<=h)high=middle;
            else low=middle+1;
        }
        return low;
    }
};
