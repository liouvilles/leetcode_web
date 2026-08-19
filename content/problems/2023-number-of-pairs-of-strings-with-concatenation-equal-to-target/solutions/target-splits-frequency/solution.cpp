class Solution {
    public: int numOfPairs(vector<string>& nums,string target){
        unordered_map<string,int> frequency;
        for(string& value:nums)++frequency[value];
        int answer=0;
        for(int split=1;split<(int)target.size();++split){
            string left=target.substr(0,split),right=target.substr(split);
            answer+=left==right?frequency[left]*(frequency[left]-1):frequency[left]*frequency[right];
        }
        return answer;
    }
};
