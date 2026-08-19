class Solution {
    public:int maximumRobots(vector<int>& chargeTimes,vector<int>& runningCosts,long long budget){
        deque<int> maximum;
        long long running=0;
        int left=0,answer=0;
        for(int right=0;right<(int)chargeTimes.size();++right){
            running+=runningCosts[right];
            while(!maximum.empty()&&chargeTimes[maximum.back()]<=chargeTimes[right])maximum.pop_back();
            maximum.push_back(right);
            while(left<=right&&chargeTimes[maximum.front()]+(right-left+1)*running>budget){
                if(maximum.front()==left)maximum.pop_front();
                running-=runningCosts[left++];
            }
            answer=max(answer,right-left+1);
        }
        return answer;
    }
};
