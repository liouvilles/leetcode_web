class Solution {
    array<int,3> topTwo(unordered_map<int,int>& count){
        int topValue=-1,top=0,second=0;
        for(auto [value,frequency]:count)if(frequency>top){
            second=top;
            top=frequency;
            topValue=value;
        }else if(frequency>second)second=frequency;
        return{
            topValue,top,second
        };
    }
    public:int minimumOperations(vector<int>& nums){
        unordered_map<int,int> even,odd;
        for(int i=0;i<(int)nums.size();++i)++(i%2?odd:even)[nums[i]];
        auto a=topTwo(even),b=topTwo(odd);
        int kept=a[0]!=b[0]?a[1]+b[1]:max(a[1]+b[2],a[2]+b[1]);
        return nums.size()-kept;
    }
};
