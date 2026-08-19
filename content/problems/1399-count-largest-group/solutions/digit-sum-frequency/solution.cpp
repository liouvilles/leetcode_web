class Solution {
    public: int countLargestGroup(int n){
        int count[100]={
        };
        for(int value=1;value<=n;++value){
            int x=value,sum=0;
            while(x){
                sum+=x%10;
                x/=10;
            }
            ++count[sum];
        }
        int maximum=*max_element(begin(count),end(count));
        return std::count(begin(count),end(count),maximum);
    }
};
