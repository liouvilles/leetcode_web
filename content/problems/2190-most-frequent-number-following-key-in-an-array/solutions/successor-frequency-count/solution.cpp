class Solution {
    public:int mostFrequent(vector<int>& nums,int key){
        unordered_map<int,int> frequency;
        int answer=0,best=0;
        for(int i=0;i+1<(int)nums.size();++i)if(nums[i]==key){
            int count=++frequency[nums[i+1]];
            if(count>best){
                best=count;
                answer=nums[i+1];
            }
        }
        return answer;
    }
};
