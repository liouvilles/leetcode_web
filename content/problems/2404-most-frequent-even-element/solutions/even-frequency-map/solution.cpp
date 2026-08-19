class Solution {
    public:int mostFrequentEven(vector<int>& nums){
        unordered_map<int,int> frequency;
        int answer=-1,best=0;
        for(int value:nums)if(value%2==0){
            int count=++frequency[value];
            if(count>best||(count==best&&(answer<0||value<answer))){
                best=count;
                answer=value;
            }
        }
        return answer;
    }
};
