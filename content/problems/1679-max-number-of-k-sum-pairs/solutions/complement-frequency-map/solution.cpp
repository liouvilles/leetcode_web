class Solution {
    public: int maxOperations(vector<int>& nums,int k){
        unordered_map<int,int> available;
        int answer=0;
        for(int value:nums){
            int complement=k-value;
            if(available[complement]){
                --available[complement];
                ++answer;
            }else ++available[value];
        }
        return answer;
    }
};
