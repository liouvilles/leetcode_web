class Solution {
    bool feasible(vector<int>& bloomDay,int m,int k,int day){
        int bouquets=0,consecutive=0;
        for(int bloom:bloomDay){
            if(bloom<=day){
                if(++consecutive==k){
                    ++bouquets;
                    consecutive=0;
                }
            }else consecutive=0;
        }
        return bouquets>=m;
    }
    public:int minDays(vector<int>& bloomDay,int m,int k){
        if(1LL*m*k>(int)bloomDay.size())return -1;
        int left=*min_element(bloomDay.begin(),bloomDay.end()),right=*max_element(bloomDay.begin(),bloomDay.end());
        while(left<right){
            int middle=left+(right-left)/2;
            if(feasible(bloomDay,m,k,middle))right=middle;
            else left=middle+1;
        }
        return left;
    }
};
