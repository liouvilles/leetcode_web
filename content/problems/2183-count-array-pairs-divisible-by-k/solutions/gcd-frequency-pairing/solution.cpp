class Solution {
    int gcd(int a,int b){
        while(b){
            int temporary=a%b;
            a=b;
            b=temporary;
        }
        return a;
    }
    public:long long countPairs(vector<int>& nums,int k){
        unordered_map<int,int> frequency;
        long long answer=0;
        for(int value:nums){
            int current=gcd(value,k);
            for(auto [other,count]:frequency)if((long long)current*other%k==0)answer+=count;
            ++frequency[current];
        }
        return answer;
    }
};
