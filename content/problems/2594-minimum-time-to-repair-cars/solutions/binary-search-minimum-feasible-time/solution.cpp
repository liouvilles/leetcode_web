class Solution {
    public:long long repairCars(vector<int>& ranks,int cars){
        long long left=0,right=1LL* *min_element(ranks.begin(),ranks.end())*cars*cars;
        while(left<right){
            long long middle=left+(right-left)/2,total=0;
            for(int rank:ranks){
                total+=sqrtl(middle/rank);
                if(total>=cars)break;
            }
            if(total>=cars)right=middle;
            else left=middle+1;
        }
        return left;
    }
};
