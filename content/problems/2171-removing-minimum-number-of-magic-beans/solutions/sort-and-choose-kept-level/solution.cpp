class Solution {
    public:long long minimumRemoval(vector<int>& beans){
        sort(beans.begin(),beans.end());
        long long total=accumulate(beans.begin(),beans.end(),0LL),answer=LLONG_MAX;
        for(int i=0;i<(int)beans.size();++i)answer=min(answer,total-(long long)(beans.size()-i)*beans[i]);
        return answer;
    }
};
