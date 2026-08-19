class Solution {
    public:vector<int> recoverArray(vector<int>& nums){
        sort(nums.begin(),nums.end());
        int half=nums.size()/2;
        for(int candidate=1;candidate<(int)nums.size();++candidate){
            int gap=nums[candidate]-nums[0];
            if(gap<=0||gap%2)continue;
            map<int,int> count;
            for(int value:nums)++count[value];
            vector<int> answer;
            bool valid=true;
            for(int low:nums){
                if(!count[low])continue;
                int high=low+gap;
                if(!count[high]){
                    valid=false;
                    break;
                }
                --count[low];
                --count[high];
                answer.push_back(low+gap/2);
            }
            if(valid&&(int)answer.size()==half)return answer;
        }
        return {
        };
    }
};
