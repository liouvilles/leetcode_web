class Solution {
    public:int countMatchingSubarrays(vector<int>& nums,vector<int>& pattern){
        int answer=0;
        for(int start=0;start+(int)pattern.size()<(int)nums.size();++start){
            bool matches=true;
            for(int index=0;index<(int)pattern.size();++index){
                int relation=(nums[start+index+1]>nums[start+index])-(nums[start+index+1]<nums[start+index]);
                if(relation!=pattern[index]){
                    matches=false;
                    break;
                }
            }
            answer+=matches;
        }
        return answer;
    }
};
