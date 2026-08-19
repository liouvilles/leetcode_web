class Solution {
public:
    vector<int> resultArray(vector<int>& nums){
        vector<int> first{nums[0]},second{nums[1]};
        for(int index=2;index<(int)nums.size();++index){
            if(first.back()>second.back())first.push_back(nums[index]);
            else second.push_back(nums[index]);
        }
        first.insert(first.end(),second.begin(),second.end());
        return first;
    }
};
