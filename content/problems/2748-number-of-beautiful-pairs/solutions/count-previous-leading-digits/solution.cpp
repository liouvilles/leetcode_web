class Solution {
    public:int countBeautifulPairs(vector<int>& nums){
        int frequency[10]={
        },answer=0;
        for(int value:nums){
            int last=value%10;
            for(int leading=1;leading<=9;++leading)if(gcd(leading,last)==1)answer+=frequency[leading];
            int first=value;
            while(first>=10)first/=10;
            ++frequency[first];
        }
        return answer;
    }
};
