class Solution { public: int reductionOperations(vector<int>& nums){sort(nums.begin(),nums.end());int answer=0;for(int i=1;i<(int)nums.size();++i)if(nums[i]!=nums[i-1])answer+=i;return answer;} };
