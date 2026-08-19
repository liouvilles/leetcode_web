class Solution {
public:
    long long maximumHappinessSum(vector<int>& happiness,int k){
        sort(happiness.rbegin(),happiness.rend());
        long long answer=0;
        for(int selected=0;selected<k;++selected)answer+=max(0LL,(long long)happiness[selected]-selected);
        return answer;
    }
};
