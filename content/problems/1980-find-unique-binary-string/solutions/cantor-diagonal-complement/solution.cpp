class Solution { public: string findDifferentBinaryString(vector<string>& nums){string answer(nums.size(),'0');for(int i=0;i<(int)nums.size();++i)answer[i]=nums[i][i]=='0'?'1':'0';return answer;} };
