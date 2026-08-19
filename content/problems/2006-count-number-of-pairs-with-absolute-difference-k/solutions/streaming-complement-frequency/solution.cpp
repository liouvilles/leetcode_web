class Solution {
    public: int countKDifference(vector<int>& nums,int k){
        unordered_map<int,int> frequency;
        int answer=0;
        for(int value:nums){
            answer+=frequency[value-k]+frequency[value+k];
            ++frequency[value];
        }
        return answer;
    }
};
