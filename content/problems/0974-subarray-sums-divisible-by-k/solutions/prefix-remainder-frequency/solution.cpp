class Solution {
    public: int subarraysDivByK(vector<int>& nums,int k){
        vector<int> frequency(k);
        frequency[0]=1;
        int remainder=0,answer=0;
        for(int value:nums){
            remainder=((remainder+value)%k+k)%k;
            answer+=frequency[remainder]++;
        }
        return answer;
    }
};
