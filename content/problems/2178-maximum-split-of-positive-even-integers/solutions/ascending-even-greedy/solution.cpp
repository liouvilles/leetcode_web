class Solution {
    public:vector<long long> maximumEvenSplit(long long finalSum){
        vector<long long> answer;
        if(finalSum%2)return answer;
        for(long long next=2;finalSum>=next;next+=2){
            answer.push_back(next);
            finalSum-=next;
        }
        if(!answer.empty())answer.back()+=finalSum;
        return answer;
    }
};
