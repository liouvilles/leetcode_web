class Solution {
    public: int minimumDeviation(vector<int>& nums){
        priority_queue<int> maximums;
        int minimum=INT_MAX;
        for(int value:nums){
            if(value%2)value*=2;
            maximums.push(value);
            minimum=min(minimum,value);
        }
        int answer=INT_MAX;
        while(true){
            int maximum=maximums.top();
            maximums.pop();
            answer=min(answer,maximum-minimum);
            if(maximum%2)break;
            maximum/=2;
            minimum=min(minimum,maximum);
            maximums.push(maximum);
        }
        return answer;
    }
};
