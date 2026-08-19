class Solution {
    public:vector<vector<int>> divideArray(vector<int>& nums,int k){
        sort(nums.begin(),nums.end());
        vector<vector<int>> answer;
        for(int start=0;start<(int)nums.size();start+=3){
            if(nums[start+2]-nums[start]>k)return {
            };
            answer.push_back({
                nums[start],nums[start+1],nums[start+2]
            });
        }
        return answer;
    }
};
